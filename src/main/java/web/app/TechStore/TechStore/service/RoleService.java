package web.app.TechStore.TechStore.service;

import web.app.TechStore.TechStore.DomainModels.Roles;
import web.app.TechStore.TechStore.service.models.AddNewRoleRequest;
import web.app.TechStore.TechStore.service.models.AddNewRoleResponse;
import web.app.TechStore.TechStore.service.models.EditRoleRequest;
import web.app.TechStore.TechStore.service.models.EditRoleResponse;

import javax.management.relation.Role;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class RoleService {
    private EntityManager entityManager;

    public RoleService(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public AddNewRoleResponse addNewRole(AddNewRoleRequest request){
        entityManager.getTransaction().begin();
        Roles role = new Roles(request.getRoleName(), request.getRoleClaim());
        entityManager.persist(role);
        entityManager.flush();
        entityManager.getTransaction().commit();
        return new AddNewRoleResponse(true);
    }

    public List<Roles> getAllRoles(){
        List<Roles> rolesList= new ArrayList<>();
        Query query = entityManager.createQuery("select r from Roles r");

        try{
            rolesList = query.getResultList();
        }catch(Exception e){
            return rolesList;
        }
        return rolesList;
    }

    public EditRoleResponse editRole(EditRoleRequest request){
        entityManager.getTransaction().begin();
        Roles role = entityManager.find(Roles.class, request.getRoleId());
        role.setRoleClaim(request.getRoleClaim());
        role.setRoleName(request.getRoleName());
        entityManager.flush();
        entityManager.getTransaction().commit();
        return new EditRoleResponse(true);
    }
}
