package web.app.TechStore.TechStore.Services.models;

public class AddNewRoleRequest {
    private String roleName;
    private long roleClaim;

    public AddNewRoleRequest(String roleName, long roleClaim) {
        this.roleName = roleName;
        this.roleClaim = roleClaim;
    }

    public String getRoleName() {
        return roleName;
    }

    public long getRoleClaim() {
        return roleClaim;
    }
}
