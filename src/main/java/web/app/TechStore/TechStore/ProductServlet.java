package web.app.TechStore.TechStore;

import web.app.TechStore.TechStore.DomainModels.Gps;
import web.app.TechStore.TechStore.service.MobileService;
import web.app.TechStore.TechStore.service.models.FilteredMobileListRequest;
import web.app.TechStore.TechStore.service.models.FilteredMobileListResponse;
import web.app.TechStore.TechStore.service.models.MobileDetailsRequest;

import java.io.*;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/product-servlet")
public class ProductServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getServletContext();
        response.setContentType("text/html");
        MobileService mobileService = (MobileService) request.getServletContext().getAttribute("mobileService");
        FilteredMobileListResponse responseRes = mobileService.getFilteredMobileList(new FilteredMobileListRequest("xiaomi"));
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>" + mobileService.getMobileDetails(new MobileDetailsRequest(1L)).getName() + "<h2>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}