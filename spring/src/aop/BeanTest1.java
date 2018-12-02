package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanTest1 {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("aop.xml");
  /*                                      
        				Ӧ��������
   �� AnnotationConfigApplicationContext:
  				��һ����������java���������м��������Ķ��壬������javaע��ķ�ʽ��
   �� ClassPathXmlApplicationContext:
  				����·���µ�һ������xml�����ļ��м��������Ķ��壬������xml���õķ�ʽ��
   �� FileSystemXmlApplicationContext:
    			���ļ�ϵͳ�µ�һ������xml�����ļ��м��������Ķ��壬Ҳ����˵ϵͳ�̷��м���xml�����ļ���
   �� AnnotationConfigWebApplicationContext:
    			ר��ΪwebӦ��׼���ģ�������ע�ⷽʽ��
   �� XmlWebApplicationContext:
    			��webӦ���µ�һ������xml�����ļ����������Ķ��壬������xml���÷�ʽ��
*/
        Person p = ctx.getBean("chinese", Person.class);
        p.useAxe();
    }
}