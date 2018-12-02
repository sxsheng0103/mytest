import org.springframework.context.ApplicationContext;  
import org.springframework.context.support.ClassPathXmlApplicationContext;

import testrmi.client.RmiService;  
public class RMIClient {  
    public static void main(String[] args) {  
        ApplicationContext context =  
            new ClassPathXmlApplicationContext("rmiclient.xml");  
        RmiService service =  (RmiService) context.getBean("rmiServiceProxy");  
        String result1 = service.doWork();  
        System.out.println(result1);  
        int result2 = service.add(1, 2);  
        System.out.println(result2);  
    }  
}