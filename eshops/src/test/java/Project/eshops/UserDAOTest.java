package Project.eshops;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import Project.eshops.Dao.UserDAO;
import Project.eshops.Model.UserDetail;

public class UserDAOTest 
{
  static UserDAO userDAO;
  
  @BeforeClass
  public static void executeFirst()
  {
	  @SuppressWarnings("resource")
	AnnotationConfigApplicationContext context=new  AnnotationConfigApplicationContext();
	  context.scan("Project.eshops");
  	  context.refresh();
  	  userDAO=(UserDAO)context.getBean("userDAO");
	  
  }

 @Ignore
 @Test
 public void adduserTest()
 {
	 UserDetail user=new UserDetail();
	 user.setUsername("Krish");
	 user.setPassword("012345");
	 user.setEmailId("krish369@gmail.com");
	 user.setCustomername("Krishna");
	 user.setEnabled(true);
	 user.setRole("ROLE_ADMIN");
	 user.setAddress("12/6,Devar Street,Villivakkam,Chennai");
	 
	 assertTrue("problem in Adding user",userDAO.registerUser(user));
	 
 }
  
 @Test
 public void updateUserTest()
 {
	 UserDetail user=userDAO.getUserDetail("Krish");
	 user.setAddress("12/6,Devar Street,Villivakkam,Chennai");
	 
	 assertTrue("problem in Updating user",userDAO.registerUser(user));
	 
	 
 }
  
}
