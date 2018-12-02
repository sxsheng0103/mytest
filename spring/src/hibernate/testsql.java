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
 * ����hibernate(4)����ɾ��Ĺ��ܷ�����
 * ����ǰ�᣺
 *     ��������eclipseEE(���Ը��������޸ĳ�������������);
 *     ���hibernate���(���ϼ��ɲ��ĺܶ���ܵİ���,���԰ٶ�һ��)�����β���ʹ��hibernate tools�Զ��������ݱ��ӳ���ļ�;
 *     ���β���ʹ��mysql���ݿ⣬���ݿ��������(user��customer),���β���ֻ����user,�ɸ�������������ݿ�����ݱ�;
 *     ����mysql�Լ�hibernate4�����jar��;
 */
public class testsql {
    public static void main(String[] args){
        // ʵ����Configuration��  
        Configuration conf = new Configuration()  
        // ���淽��Ĭ�ϼ���hibernate.cfg.xml�ļ�  
                .configure();  
        // ��Configuration����SessionFactory ,hibernate4�汾֮��ֱ��ʹ�� conf.buildSessionFactory()���Ѿ���ʱ�˵ģ�
        ServiceRegistryBuilder serviceRegistry = new ServiceRegistryBuilder()
        								.applySettings(conf.getProperties());
        SessionFactory sf = conf.buildSessionFactory(serviceRegistry.buildServiceRegistry());
        
        // ����Session  
        Session sess = sf.openSession();  
        // ��ʼ����  
        Transaction tx = sess.beginTransaction();  
        // ����ʵ�����󣬽��г־û����������潫ʹ�ö��ַ�����������ɾ���顢�Ĳ��ԣ� ��Ҫ������һ�ַ�����ȥ��ע�ͣ�
        Cat cat = new Cat();  
        Query q = sess.createQuery("select * from person");
        List list = q.list();
        
//        isdelete(tuser,sess);//ɾ1
//        isdelete1(tuser,sess);//ɾ2
//        isupdate(tuser,sess);//��1
//        isupdate1(tuser,sess);//��2
//        List<TUser> list = isquery1(sess);
//        System.out.println("���������ѯ��������"+list.get(0).getUserName());//��1
//        TUser user=isquery(tuser,sess);
//        System.out.println("����id��ѯ����������"+user.getUserName());//��2
//		  List<TUser> list = isquery2(sess);
//		  System.out.println("���󻯲�ѯ��������"+list.get(0).getUserName());//��3
        // �ύ����  
        tx.commit();  
        // �ر�Session  
        sess.close();  
        sf.close();  
    } 
}