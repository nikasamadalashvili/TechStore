package web.app.TechStore.TechStore;

import web.app.TechStore.TechStore.service.MobileService;
import web.app.TechStore.TechStore.service.models.MobileDetailsRequest;
import web.app.TechStore.TechStore.service.models.MobileDetailsResponse;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MobileDetailsServlet", value = "/mobile-details")
public class MobileDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MobileService service = (MobileService) request.getServletContext().getAttribute("mobileService");
        MobileDetailsResponse mobileDetails = service.getMobileDetails(new MobileDetailsRequest(Long.parseLong(request.getParameter("mobileId"))));
        request.setAttribute("mobileDetails", mobileDetails);
        request.setAttribute("viewName", "mobile-details.jsp");
        request.getRequestDispatcher("main.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
