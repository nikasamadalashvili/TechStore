package web.app.TechStore.TechStore;

import web.app.TechStore.TechStore.service.UserService;
import web.app.TechStore.TechStore.service.models.UserDetails;
import web.app.TechStore.TechStore.service.models.UserDetailsRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "profile", value = "/profile")
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDetailsRequest detailsRequest = new UserDetailsRequest(4L);
        UserService userService = (UserService) req.getServletContext().getAttribute("userService");

        UserDetails userDetails = userService.getUserDetails(detailsRequest);
        if(userDetails != null) {
            req.setAttribute("firstName", userDetails.getFirstName());
            req.setAttribute("lastName", userDetails.getLastName());
            req.setAttribute("email", userDetails.getEmail());
            req.setAttribute("username", userDetails.getUsername());
            req.setAttribute("image", userDetails.getImage());
            req.setAttribute("viewName","profile-view.jsp");
            req.getRequestDispatcher("/main.jsp").forward(req, resp);
        }
    }
}
