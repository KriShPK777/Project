package Project.eshops;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GeneralTest 
{
	public static void main(String args[])
	{
	@SuppressWarnings("resource")
	AnnotationConfigApplicationContext context=new  AnnotationConfigApplicationContext();
	context.scan("Project.eshops");
	context.refresh();

	}

}
