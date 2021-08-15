package web.app.TechStore.TechStore.DomainModels;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Roles {
    private long roleId;
    private String roleName;
    private long roleClaim;

    @Id
    @Column(name = "roleID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "role_name", nullable = false, length = 64)
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Basic
    @Column(name = "role_claim", nullable = false)
    public long getRoleClaim() {
        return roleClaim;
    }

    public void setRoleClaim(long roleClaim) {
        this.roleClaim = roleClaim;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roles roles = (Roles) o;
        return roleId == roles.roleId && roleClaim == roles.roleClaim && Objects.equals(roleName, roles.roleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, roleName, roleClaim);
    }
}
