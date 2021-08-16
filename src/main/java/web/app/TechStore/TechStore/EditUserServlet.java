package web.app.TechStore.TechStore;

import lombok.SneakyThrows;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.tika.mime.MimeType;
import org.apache.tika.mime.MimeTypes;
import web.app.TechStore.TechStore.service.UserService;
import web.app.TechStore.TechStore.service.models.UserDetails;
import web.app.TechStore.TechStore.service.models.UserDetailsRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "profile-edit",value = "/profile-edit")
public class EditUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDetailsRequest detailsRequest = new UserDetailsRequest(4L);
        UserService userService = (UserService) req.getServletContext().getAttribute("userService");

        UserDetails userDetails = userService.getUserDetails(detailsRequest);
        if(userDetails != null) {
            req = setAttributes(req,userDetails);
            req.getRequestDispatcher("/profile-edit.jsp").forward(req, resp);
        }
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDetailsRequest detailsRequest = new UserDetailsRequest(4L);
        UserDetails userDetails = new UserDetails(req.getParameter("firstName"),req.getParameter("lastName"),
                                            req.getParameter("email"), req.getParameter("username"),"");
        UserService userService = (UserService) req.getServletContext().getAttribute("userService");

        String appPath = "/home/nika/Desktop/TechStore/src/main/webapp/images/";
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.parseRequest(req).stream()
                .filter(o -> !((FileItem)o).isFormField())
                .forEach(o -> {
                    FileItem item = (FileItem) o;
                    try {
                        MimeType mimeType = MimeTypes.getDefaultMimeTypes().forName(item.getContentType());
                        String fileName = UUID.randomUUID() + mimeType.getExtension();
                        userDetails.setImage(fileName);
                        File newImagePath = new File(appPath + fileName);
                        item.write(newImagePath);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

        boolean hasChanged = userService.changeProfile(detailsRequest,userDetails);
        if(hasChanged) {
            req = setAttributes(req,userService.getUserDetails(detailsRequest));
            req.getRequestDispatcher("/profile-view.jsp").forward(req,resp);
        }
    }

    private HttpServletRequest setAttributes(HttpServletRequest req, UserDetails userDetails) {
        req.setAttribute("firstName", userDetails.getFirstName());
        req.setAttribute("lastName", userDetails.getLastName());
        req.setAttribute("email", userDetails.getEmail());
        req.setAttribute("username", userDetails.getUsername());
        req.setAttribute("image", userDetails.getImage());
        return req;
    }
}
