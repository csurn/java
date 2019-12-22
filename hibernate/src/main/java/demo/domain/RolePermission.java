package demo.domain;

import lombok.Data;

import javax.persistence.*;

@Table(uniqueConstraints = {@UniqueConstraint(columnNames={"roleId","permissionId"})})
@Data
@Entity
public class RolePermission extends BaseEntity {
    @Column(name = "roleId", updatable = false, insertable = false)
    private String roleId;
    @Column(name = "permissionId", updatable = false, insertable = false)
    private String permissionId;
    @JoinColumn(name = "roleId")
    @ManyToOne(targetEntity = Role.class)
    private Role role;
    @JoinColumn(name = "permissionId")
    @ManyToOne(targetEntity = Permission.class)
    private Permission permission;
}
