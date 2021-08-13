package web.app.TechStore.TechStore;

import web.app.TechStore.TechStore.DomainModels.Gps;
import web.app.TechStore.TechStore.service.models.MobileDetailsRequest;
import web.app.TechStore.TechStore.service.models.MobileService;

import java.io.*;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    @Inject
    TestServiceOne testServiceOne;

    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getServletContext();
        response.setContentType("text/html");
        MobileService mobileService = (MobileService) request.getServletContext().getAttribute("mobileService");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<h2>" + mobileService.getMobileDetails(new MobileDetailsRequest(1L)).getName() + "<h2>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}