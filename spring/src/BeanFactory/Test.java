package BeanFactory;


import BeanFactory.inter.Person;
 
public class Test
{
    /**
     * main:(这里用一句话描述这个方法的作用). <br/>
     * @author syzhao
     * @param args
     * @since JDK 1.6
     */
    public static void main(String[] args)
    {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("beanfactory.xml");
        Person person = (Person)beanFactory.getBean("student");
        person.work();
        person = (Person)beanFactory.getBean("teacher");
        person.work();
    }
    
}
