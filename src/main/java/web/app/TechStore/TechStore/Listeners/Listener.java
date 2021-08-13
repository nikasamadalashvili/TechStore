package web.app.TechStore.TechStore.Listeners;

import web.app.TechStore.TechStore.service.models.MobileService;

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
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tech-store");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        MobileService mobileService = new MobileService(entityManager);
        sre.getServletContext().setAttribute("mobileService",mobileService);
    }
}
