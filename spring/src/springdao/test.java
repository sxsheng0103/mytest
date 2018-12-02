package springdao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class test {
	public static void main(String[] args) {
		 ApplicationContext ctx = new ClassPathXmlApplicationContext("springdao.xml");
		 PersonDaoImpl p = ctx.getBean("personDaoImpl", PersonDaoImpl.class);
		 List<Person> ps= p.findById(4);
		 for(Person e : ps) {
			 System.out.println("ID:  ->   "+e.id+"  NAME: ->  "+ e.name+ "     AGE:  ->"+e.age);
		 }
	}
}
