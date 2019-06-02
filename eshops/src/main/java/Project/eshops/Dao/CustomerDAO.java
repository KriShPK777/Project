package Project.eshops.Dao;

import Project.eshops.Model.Customer;

public interface CustomerDAO 
{
	void registerCustomer(Customer customer);
	boolean isEmailUnique(String email);
	
}
