package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanTest1 {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("aop.xml");
  /*                                      
        				应用上下文
   ① AnnotationConfigApplicationContext:
  				从一个或多个基于java的配置类中加载上下文定义，适用于java注解的方式；
   ② ClassPathXmlApplicationContext:
  				从类路径下的一个或多个xml配置文件中加载上下文定义，适用于xml配置的方式；
   ③ FileSystemXmlApplicationContext:
    			从文件系统下的一个或多个xml配置文件中加载上下文定义，也就是说系统盘符中加载xml配置文件；
   ④ AnnotationConfigWebApplicationContext:
    			专门为web应用准备的，适用于注解方式；
   ⑤ XmlWebApplicationContext:
    			从web应用下的一个或多个xml配置文件加载上下文定义，适用于xml配置方式。
*/
        Person p = ctx.getBean("chinese", Person.class);
        p.useAxe();
    }
}