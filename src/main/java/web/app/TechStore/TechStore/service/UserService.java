package web.app.TechStore.TechStore.service;

import web.app.TechStore.TechStore.service.MobileService;

import javax.persistence.EntityManager;

public class UserService {
    private MobileService service;

    public UserService(MobileService service, EntityManager entityManager) {
        this.service =  service;
    }


}
