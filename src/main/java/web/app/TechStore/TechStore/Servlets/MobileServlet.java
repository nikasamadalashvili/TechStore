package web.app.TechStore.TechStore.Servlets;

import com.google.gson.Gson;
import web.app.TechStore.TechStore.Services.AuthenticationService;
import web.app.TechStore.TechStore.Services.MobileService;
import web.app.TechStore.TechStore.Services.models.FilteredMobileListRequest;
import web.app.TechStore.TechStore.Services.models.FilteredMobileListResponse;
import web.app.TechStore.TechStore.Services.models.ShoppingCartDto;

import javax.inject.Inject;
import javax.json.bind.JsonbBuilder;
import javax.security.enterprise.SecurityContext;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        request.setAttribute("brands",mobileService.getBrands().getBrands());
        request.setAttribute("rams",mobileService.getRam().getRams());
        request.setAttribute("mobiles", filteredMobileList.getFilteredProducts());
        request.setAttribute("viewName", "mobile-index.jsp");
        request.getRequestDispatcher("main.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String[][] aa =  JsonbBuilder.create().fromJson(request.getReader(), String[][].class);
        List<String> brands = Arrays.asList(aa[0]);
        List<String> rams = Arrays.asList(aa[1]);
        FilteredMobileListResponse filteredMobileList = mobileService.getFilteredMobileList(new FilteredMobileListRequest(null,
                brands, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), rams, new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(), 0.0, 1000000.0));
        request.setAttribute("brands",mobileService.getBrands().getBrands());
        request.setAttribute("rams",mobileService.getRam().getRams());
        request.setAttribute("mobiles", filteredMobileList.getFilteredProducts());
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String mobiles = new Gson().toJson(filteredMobileList.getFilteredProducts());
        out.print(mobiles);
        out.flush();
        //request.setAttribute("viewName", "mobile-index.jsp");
        //request.getRequestDispatcher("main.jsp").forward(request, response);
    }
}
