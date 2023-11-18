package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
   @PersistenceContext private EntityManager entityManager;

   @Override
   public void addUser(User user) {
      entityManager.persist(user);
   }

   @Override
   public void deleteUser(long id) {
      entityManager.remove(entityManager.find(User.class, id));
   }

   @Override
   public User getUserById(long id) {
      return entityManager.find(User.class, id);
   }

   @Override
   public void updateUser(User user) {
      entityManager.merge(user);
   }

   @Override
   public List<User> listUsers() {
      TypedQuery<User> query= entityManager.createQuery("from User u", User.class);
      return query.getResultList();
   }

}
