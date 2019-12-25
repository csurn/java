package demo;

import demo.UserRepository;
import demo.domain.User;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class UserRepositoryImpl extends SimpleJpaRepository<User,String> implements UserRepository {
    private final EntityManager em;

    public UserRepositoryImpl(EntityManager em) {
        super(User.class, em);
        this.em=em;
    }

    @Override
    public List<User> search(String search,int page,int size) {
       return this.em.createQuery(search).setFirstResult(page).setMaxResults(size).getResultList();
    }
}
