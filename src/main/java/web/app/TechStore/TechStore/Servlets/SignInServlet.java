package web.app.TechStore.TechStore.Servlets;

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

@WebServlet(value = "/sign-in")
public class SignInServlet extends HttpServlet {
    @Inject
    private AuthenticationService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("sign-in.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");

        AuthenticationResponse response = service.getUserId(new AuthenticationRequest(userName, password));
        if (response.isIdAndPassRight()) {
            TechStoreAuthenticationCookieModel cookieModel = new TechStoreAuthenticationCookieModel();
            cookieModel.setUserName(response.getUserName());
            resp.addCookie(new Cookie("TechStoreAuthenticationResult", JsonbBuilder.create().toJson(cookieModel)));
            resp.sendRedirect(req.getContextPath() + "/mobiles");
        }
        else {
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }
}
