package web.app.TechStore.TechStore.Servlets;

import lombok.SneakyThrows;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import web.app.TechStore.TechStore.Services.AuthenticationService;
import web.app.TechStore.TechStore.Services.models.AuthenticationRequest;
import web.app.TechStore.TechStore.Services.models.AuthenticationResponse;
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
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;

@WebServlet(value = "/sign-in")
public class SignInServlet extends HttpServlet {
    @Inject
    private AuthenticationService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("sign-in.jsp").forward(req, resp);
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

        AuthenticationResponse response = service.getUserId(new AuthenticationRequest(resultSet.get("UserName"), resultSet.get("Password")));
        if (response.isIdAndPassRight()) {
            resp.addCookie(new Cookie("UserName", response.getUserName()));
            resp.sendRedirect(req.getContextPath() + "/mobiles");
        }
        else {
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }
}
