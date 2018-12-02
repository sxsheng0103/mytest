package hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
 
/**
 * @author xiaohe
 * 测试hibernate(4)的增删查改功能方法；
 * 测试前提：
 *     开发工具eclipseEE(可以根据需求修改成其他开发工具);
 *     搭建好hibernate框架(网上即可查阅很多搭建框架的案例,可以百度一下)，本次测试使用hibernate tools自动生成数据表和映射文件;
 *     本次测试使用mysql数据库，数据库表有两个(user和customer),本次测试只运用user,可根据需求更换数据库和数据表;
 *     加入mysql以及hibernate4等相关jar包;
 */
public class testsql {
    public static void main(String[] args){
        // 实例化Configuration，  
        Configuration conf = new Configuration()  
        // 下面方法默认加载hibernate.cfg.xml文件  
                .configure();  
        // 以Configuration创建SessionFactory ,hibernate4版本之后直接使用 conf.buildSessionFactory()是已经过时了的；
        ServiceRegistryBuilder serviceRegistry = new ServiceRegistryBuilder()
        								.applySettings(conf.getProperties());
        SessionFactory sf = conf.buildSessionFactory(serviceRegistry.buildServiceRegistry());
        
        // 创建Session  
        Session sess = sf.openSession();  
        // 开始事务  
        Transaction tx = sess.beginTransaction();  
        // 创建实例对象，进行持久化操作，下面将使用多种方法进行增、删、查、改测试， 需要测试哪一种方法可去掉注释；
        Cat cat = new Cat();  
        Query q = sess.createQuery("select * from person");
        List list = q.list();
        
//        isdelete(tuser,sess);//删1
//        isdelete1(tuser,sess);//删2
//        isupdate(tuser,sess);//改1
//        isupdate1(tuser,sess);//改2
//        List<TUser> list = isquery1(sess);
//        System.out.println("根据年龄查询的姓名："+list.get(0).getUserName());//查1
//        TUser user=isquery(tuser,sess);
//        System.out.println("根据id查询到的姓名："+user.getUserName());//查2
//		  List<TUser> list = isquery2(sess);
//		  System.out.println("对象化查询的姓名："+list.get(0).getUserName());//查3
        // 提交事务  
        tx.commit();  
        // 关闭Session  
        sess.close();  
        sf.close();  
    } 
}