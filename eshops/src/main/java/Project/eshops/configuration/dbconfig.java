package Project.eshops.configuration;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import Project.eshops.Model.Category;
import Project.eshops.Model.CartItem;
import Project.eshops.Model.Product;
import Project.eshops.Model.UserDetail;

@org.springframework.context.annotation.Configuration
@EnableTransactionManagement
@ComponentScan("Project.eshops")

public class dbconfig 
{
 	@Bean(name="dataSource")
	public DriverManagerDataSource getH2DataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/Project");
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");
		
		System.out.println("---DataSource object is Created---");
		return dataSource;
			
	}
	

	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		Properties properties=new Properties();
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		
		DriverManagerDataSource dataSource=this.getH2DataSource();
		LocalSessionFactoryBuilder factory=new LocalSessionFactoryBuilder(dataSource);
		factory.addProperties(properties);
		
		factory.addAnnotatedClass(Category.class);
		factory.addAnnotatedClass(Product.class);
		factory.addAnnotatedClass(UserDetail.class);
		factory.addAnnotatedClass(CartItem.class);
	
		
		
		System.out.println("---Session Factory Object is Created---");
		SessionFactory sessionFactory=factory.buildSessionFactory();
		return sessionFactory;
		
	}
	
	@Bean(name="txManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("---Transaction Manager Object is Created---");
		return new HibernateTransactionManager(sessionFactory);
		
		
		
		
	}
	
	}


