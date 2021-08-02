package webapp.techstore;

import java.io.*;
import java.security.Principal;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.security.enterprise.SecurityContext;
import javax.security.enterprise.identitystore.IdentityStoreHandler;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    @Inject
    private TestServiceOne testServiceOne;
    @Inject
    private TestServiceTwo serviceTwo;
    @Inject
    private SecurityContext securityContext;
   @Inject
   private repo rep;


    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        rep.update();
        response.setContentType("text/html");
        //Principal callerPrincipal = securityContext.getUserPrincipal();
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + testServiceOne.greetingFromServiceOne() + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}