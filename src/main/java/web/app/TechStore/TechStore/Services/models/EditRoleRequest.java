package web.app.TechStore.TechStore.Services.models;

public class EditRoleRequest {
    private long roleClaim;
    private long roleId;
    private String roleName;

    public EditRoleRequest(long roleClaim, long roleId, String roleName) {
        this.roleClaim = roleClaim;
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public long getRoleClaim() {
        return roleClaim;
    }

    public long getRoleId() {
        return roleId;
    }

    public String getRoleName() {
        return roleName;
    }
}
