package demo;

import demo.domain.*;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.List;

//https://github.com/hibernate/hibernate-demos
public class App {
    public static void main(String[] args) {
        Session session = openSession();
        session.getTransaction().begin();
        session.persist(new User());
        session.getTransaction().commit();
        CriteriaExt<User> criteria = new CriteriaExt<User>(session.createCriteria(User.class));
        List<User> users= criteria.add(User::getUserName,"").list();
        session.close();
    }

    private static SessionFactory sessionFactory = null;

    private static Session openSession() {
        if (sessionFactory == null) {
            final Configuration configuration = new Configuration();
            configuration.addAnnotatedClass( User.class );
            configuration.addAnnotatedClass( Role.class );
            configuration.addAnnotatedClass( Permission.class );
            configuration.addAnnotatedClass( UserRole.class );
            configuration.addAnnotatedClass( RolePermission.class );

            sessionFactory = configuration.buildSessionFactory( new StandardServiceRegistryBuilder().build() );
        }
        return sessionFactory.openSession();
    }
}
