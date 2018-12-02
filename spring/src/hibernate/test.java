package hibernate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aop.Person;

public class test {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("hibernate.xml");
		CatDaoImpl c = ctx.getBean("catDao", CatDaoImpl.class);
		System.out.println(c.listCats());
	}
    

}
