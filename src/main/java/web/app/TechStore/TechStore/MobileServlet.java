package web.app.TechStore.TechStore;

import web.app.TechStore.TechStore.service.MobileService;
import web.app.TechStore.TechStore.service.models.AddProductRequest;
import web.app.TechStore.TechStore.service.models.FilteredMobileListRequest;
import web.app.TechStore.TechStore.service.models.FilteredMobileListResponse;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "MobileServlet", value = "/mobiles")
public class MobileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MobileService mobileService = (MobileService)request.getServletContext().getAttribute("mobileService");
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
