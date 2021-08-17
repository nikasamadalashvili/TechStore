package web.app.TechStore.TechStore.Servlets;

import web.app.TechStore.TechStore.Services.AuthenticationService;
import web.app.TechStore.TechStore.Services.MobileService;
import web.app.TechStore.TechStore.Services.models.FilteredMobileListRequest;
import web.app.TechStore.TechStore.Services.models.FilteredMobileListResponse;

import javax.inject.Inject;
import javax.security.enterprise.SecurityContext;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "MobileServlet", value = "/mobiles")
public class MobileServlet extends HttpServlet {
    @Inject
    SecurityContext cont;

    @Inject
    AuthenticationService asd;

    @Inject
    MobileService mobileService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FilteredMobileListResponse filteredMobileList = mobileService.getFilteredMobileList(new FilteredMobileListRequest(null,
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(), 0.0, 1000000.0));
        request.setAttribute("mobiles", filteredMobileList.getFilteredProducts());
        request.setAttribute("viewName", "mobile-index.jsp");
        request.getRequestDispatcher("main.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
