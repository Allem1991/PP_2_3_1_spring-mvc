package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
   void addUser(User user);
   void deleteUser(long id);
   User getUserById(long id);
   void updateUser(User user);
   List<User> listUsers();
}
