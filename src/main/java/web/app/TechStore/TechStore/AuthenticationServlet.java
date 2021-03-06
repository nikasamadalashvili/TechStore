package web.app.TechStore.TechStore;

import web.app.TechStore.TechStore.Services.AuthenticationService;
import web.app.TechStore.TechStore.Services.models.AuthenticationRequest;
import web.app.TechStore.TechStore.Services.models.AuthenticationResponse;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "authentication", value="/authentication")
public class AuthenticationServlet extends HttpServlet {
    @Inject
    AuthenticationService authenticationService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        AuthenticationResponse authenticationResponse =
                authenticationService.getUserId(new AuthenticationRequest
                        (req.getParameter("name"), req.getParameter("pass")));
        req.setAttribute("isIDandPASSright", authenticationResponse.isIdAndPassRight());
        req.setAttribute("userID", authenticationResponse.getUserId());
        req.setAttribute("viewName", "authentication.jsp");
        req.getRequestDispatcher("main.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
