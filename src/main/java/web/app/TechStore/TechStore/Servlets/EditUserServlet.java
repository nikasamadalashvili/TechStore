package web.app.TechStore.TechStore.Servlets;

import lombok.SneakyThrows;
import web.app.TechStore.TechStore.DomainModels.Users;
import web.app.TechStore.TechStore.Services.UserService;
import web.app.TechStore.TechStore.Services.models.UserDetails;
import web.app.TechStore.TechStore.Services.models.UserDetailsRequest;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "profile-edit",value = "/profile-edit")
public class EditUserServlet extends HttpServlet {

    @Inject
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Users user = (Users) req.getAttribute("SignedUser");
        UserDetailsRequest detailsRequest = new UserDetailsRequest(user.getUserId());

        UserDetails userDetails = userService.getUserDetails(detailsRequest);
        if(userDetails != null) {
            req = setAttributes(req,userDetails);
            req.setAttribute("viewName","profile-edit.jsp");
            req.getRequestDispatcher("/main.jsp").forward(req, resp);
        }
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String appPath = "/home/nika/Desktop/TechStore/src/main/webapp/images/";
//        FileItemFactory factory = new DiskFileItemFactory();
//        ServletFileUpload upload = new ServletFileUpload(factory);
        Users user = (Users) req.getAttribute("SignedUser");
        UserDetailsRequest detailsRequest = new UserDetailsRequest(user.getUserId());
        UserDetails userDetails = new UserDetails(req.getParameter("firstName"),req.getParameter("lastName"),
                req.getParameter("email"), req.getParameter("username"),"");
//        HashMap<String, String> parameters = new HashMap<>();
//        upload.parseRequest(req).stream()
//                .forEach(o -> {
//                    FileItem item = (FileItem) o;
//                    if (item.isFormField()) {
//                        parameters.put(item.getFieldName(), item.getString());
//                    }
//                    else {
//                        try {
//                            MimeType mimeType = MimeTypes.getDefaultMimeTypes().forName(item.getContentType());
//                            String fileName = UUID.randomUUID() + mimeType.getExtension();
//                            userDetails.setImage(fileName);
//                            File newImagePath = new File(appPath + fileName);
//                            item.write(newImagePath);
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    }
//                });
//
//        userDetails.setEmail(parameters.get("email"));
//        userDetails.setFirstName(parameters.get("firstName"));
//        userDetails.setLastName(parameters.get("lastName"));
//        userDetails.setEmail(parameters.get("username"));

        boolean hasChanged = userService.changeProfile(detailsRequest,userDetails);
        if(hasChanged) {
            req = setAttributes(req,userService.getUserDetails(detailsRequest));
            req.setAttribute("viewName","profile-view.jsp");
            req.getRequestDispatcher("/main.jsp").forward(req, resp);
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
