package web.app.TechStore.TechStore;

import web.app.TechStore.TechStore.DomainModels.Gps;

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
        response.setContentType("text/html");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tech-store");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            List<String> test = entityManager.createQuery("select s.aGps from Gps s").getResultList();
            test.forEach(System.out :: println);
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<h2>" + testServiceOne.greetingFromServiceOne() + "<h2>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}