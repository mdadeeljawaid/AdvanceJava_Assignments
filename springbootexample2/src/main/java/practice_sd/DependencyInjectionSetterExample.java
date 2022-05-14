package practice_sd;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DependencyInjectionSetterExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		Lead  lead =(Lead) context.getBean("leadbean");
		System.out.println("Lead id is"+lead.getLeadid());
		System.out.println("Lead name is"+lead.getLeadName());
		System.out.println("Lead course is"+lead.getLeadCourse());
		
		MyProduct product= (MyProduct) context.getBean("myproduct1");
		System.out.println("Product name"+product.getMproductName());
		product.productInfo();
	}

}