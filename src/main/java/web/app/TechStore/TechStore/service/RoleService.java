package web.app.TechStore.TechStore.service;

import web.app.TechStore.TechStore.DomainModels.Roles;
import web.app.TechStore.TechStore.service.models.AddNewRoleRequest;
import web.app.TechStore.TechStore.service.models.AddNewRoleResponse;
import web.app.TechStore.TechStore.service.models.EditRoleRequest;
import web.app.TechStore.TechStore.service.models.EditRoleResponse;

import javax.management.Query;
import javax.management.relation.Role;
import javax.persistence.EntityManager;

public class RoleService {
    private EntityManager entityManager;

    public RoleService(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public AddNewRoleResponse addNewRole(AddNewRoleRequest request){
        entityManager.getTransaction().begin();
        Roles role = new Roles(request.getRoleName(), request.getRoleClaim());
        entityManager.persist(role);
        entityManager.getTransaction().commit();
        return new AddNewRoleResponse(true);
    }

    public long roleIdByName(String roleName){ //?
        return 0;
    }

    public EditRoleResponse editRole(EditRoleRequest request){
        entityManager.getTransaction().begin();
        Roles role = entityManager.find(Roles.class, request.getRoleId());
        role.setRoleClaim(request.getRoleClaim());
        role.setRoleName(request.getRoleName());
        entityManager.getTransaction().commit();
        return new EditRoleResponse(true);
    }
}
