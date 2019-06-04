package Project.eshops.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Project.eshops.Model.Authorities;
import Project.eshops.Model.Customer;
import Project.eshops.Model.UserDetail;

@Repository
@Transactional

public class CustomerDAOImpl implements CustomerDAO
{
   @Autowired
   SessionFactory sessionFactory;

@Override
public void registerCustomer(Customer customer) 
{
	Session session=sessionFactory.getCurrentSession();
	  customer.getUser().setEnabled(true);	   
	  // System.out.println(customer.getUser().getAuthorities());
	   Authorities authorities=new Authorities();
	   authorities.setRole("ROLE_USER");
	   //customer.getUser().setAuthorities(authorities);
	   authorities.setUser(customer.getUser());
	   session.save(customer);
	
}

@Override
public boolean isEmailUnique(String email) 
{
	Session session=sessionFactory.getCurrentSession();
	UserDetail user=(UserDetail)session.get(UserDetail.class, email);
	if(user==null)
		return true;
		else
		return false;	
	
}
	
	
}
