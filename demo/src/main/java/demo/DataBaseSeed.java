package demo;

import demo.domain.*;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
public class DataBaseSeed {

    @PersistenceContext
    EntityManager em;

    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void init() {
        User user = new User();
        user.setUserName("admin");
        user.setPassword("123456");
        em.persist(user);

        Role role = new Role();
        role.setName("Radmin");
        em.persist(role);

        Permission permission = new Permission();
        permission.setName("Padmin");
        em.persist(permission);

        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());
        userRole.setRoleId(role.getId());
        user.getUserRoles().add(userRole);
        em.persist(userRole);

        RolePermission rolePermission = new RolePermission();
        rolePermission.setRoleId(role.getId());
        rolePermission.setPermissionId(permission.getId());
        role.getRolePermissions().add(rolePermission);
        em.persist(rolePermission);

    }
}
