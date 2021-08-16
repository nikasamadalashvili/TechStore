package web.app.TechStore.TechStore.Listeners;

import web.app.TechStore.TechStore.service.CreditCardService;
import web.app.TechStore.TechStore.service.MobileService;
import web.app.TechStore.TechStore.service.UserService;

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
        sre.getServletContext().removeAttribute("cardsService");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tech-store");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        MobileService mobileService = new MobileService(entityManager);
        sre.getServletContext().setAttribute("mobileService",mobileService);
        UserService userService = new UserService(mobileService, entityManager);
        sre.getServletContext().setAttribute("userService", userService);

        CreditCardService creditCardService = new CreditCardService(entityManager);
        sre.getServletContext().setAttribute("cardService",creditCardService);
    }
}
