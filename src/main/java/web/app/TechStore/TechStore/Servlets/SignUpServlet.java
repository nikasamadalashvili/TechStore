package web.app.TechStore.TechStore.Servlets;

import lombok.SneakyThrows;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import web.app.TechStore.TechStore.Services.AuthenticationService;
import web.app.TechStore.TechStore.Services.models.SignUpUserRequest;
import web.app.TechStore.TechStore.Services.models.SignUpUserResponse;
import web.app.TechStore.TechStore.Utils.TechStoreAuthenticationCookieModel;

import javax.inject.Inject;
import javax.json.bind.JsonbBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(value = "/sign-up")
public class SignUpServlet extends HttpServlet {

    @Inject
    AuthenticationService authenticationService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("sign-up.jsp").forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        HashMap<String, String> resultSet = new HashMap<>();
        upload.parseRequest(req).stream()
                .filter(o -> ((FileItem)o).isFormField())
                .forEach(o -> {
                    FileItem item = (FileItem) o;
                    resultSet.put(item.getFieldName(), item.getString());
                });
        SignUpUserRequest signUpUserRequest = new SignUpUserRequest(resultSet.get("UserName"), resultSet.get("Password"),resultSet.get("Email"), resultSet.get("FirstName"), resultSet.get("LastName"));

        SignUpUserResponse response = authenticationService.signUpUser(signUpUserRequest);
        if (response.HasSucceeded) {
            TechStoreAuthenticationCookieModel cookieModel = new TechStoreAuthenticationCookieModel();
            cookieModel.setUserName(response.User.getUsername());
            String value = JsonbBuilder.create().toJson(cookieModel);
            resp.addCookie(new Cookie("UserName", response.User.getUsername()));
            resp.sendRedirect(req.getContextPath() + "/mobiles");
        }
        else {
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }
}
