package Project.eshops;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GeneralTest 
{
	public static void main(String args[])
	{
	
	AnnotationConfigApplicationContext context=new  AnnotationConfigApplicationContext();
	context.scan("Project.eshops");
	context.refresh();

	}

}
