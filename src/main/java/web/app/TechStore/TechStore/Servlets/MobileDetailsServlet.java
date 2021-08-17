package web.app.TechStore.TechStore.Servlets;

import web.app.TechStore.TechStore.Services.MobileService;
import web.app.TechStore.TechStore.Services.models.MobileDetailsRequest;
import web.app.TechStore.TechStore.Services.models.MobileDetailsResponse;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MobileDetailsServlet", value = "/mobile-details")
public class MobileDetailsServlet extends HttpServlet {

    @Inject
    private MobileService mobileService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MobileDetailsResponse mobileDetails = mobileService.getMobileDetails(new MobileDetailsRequest(Long.parseLong(request.getParameter("mobileId"))));
        request.setAttribute("mobileDetails", mobileDetails);
        request.setAttribute("viewName", "mobile-details.jsp");
        request.getRequestDispatcher("main.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
