package demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Table(uniqueConstraints = {@UniqueConstraint(columnNames={"userId","roleId"})})
@Entity
public class UserRole extends BaseEntity {
    @Column(name = "userId", updatable = false, insertable = false)
    private String userId;
    @Column(name = "roleId", updatable = false, insertable = false)
    private String roleId;
    @JsonBackReference
    @JoinColumn(name = "userId")
    @ManyToOne(targetEntity = User.class)
    private User user;

    @JoinColumn(name = "roleId")
    @ManyToOne(targetEntity = Role.class)
    private Role role;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}