package web.app.TechStore.TechStore.Listeners;

import web.app.TechStore.TechStore.Services.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Listener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        sre.getServletContext().removeAttribute("mobileService");
        sre.getServletContext().removeAttribute("userService");
        sre.getServletContext().removeAttribute("shoppingCartService");
        sre.getServletContext().removeAttribute("roleService");
        sre.getServletContext().removeAttribute("authenticationService");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tech-store");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        //MobileService mobileService = new MobileService(entityManager);
        //sre.getServletContext().setAttribute("mobileService",mobileService);
        //UserService userService = new UserService(mobileService, entityManager);
        //sre.getServletContext().setAttribute("userService", userService);
        ShoppingCartService shoppingCartService = new ShoppingCartService(entityManager);
        sre.getServletContext().setAttribute("shoppingCartService", shoppingCartService);
        RoleService roleService = new RoleService(entityManager);
        sre.getServletContext().setAttribute("roleService", roleService);
        CreditCardService cardService = new CreditCardService(entityManager);
        sre.getServletContext().setAttribute("cardService",cardService);
        AuthenticationService authenticationService = new AuthenticationService(entityManager);
        sre.getServletContext().setAttribute("authenticationService", authenticationService);
    }
}
