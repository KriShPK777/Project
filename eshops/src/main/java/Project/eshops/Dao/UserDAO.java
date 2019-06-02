package Project.eshops.Dao;

import Project.eshops.Model.UserDetail;

public interface UserDAO 
{
 public boolean registerUser(UserDetail user);
 public boolean updateUser(UserDetail user);
 public UserDetail getUserDetail(String username);
}
