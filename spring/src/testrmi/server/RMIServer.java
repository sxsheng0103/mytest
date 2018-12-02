package testrmi.server;  
import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import org.springframework.context.support.ClassPathXmlApplicationContext;  
public class RMIServer {  
    public static void main(String[] args) throws IOException { 
    	System.out.println("Æô¶¯");
        new ClassPathXmlApplicationContext("rmiserver.xml");  
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
        System.out.println("Æô¶¯");
        while (true) {
            if (reader.readLine().equals("exit")) {  
                System.exit(0);  
            }  
        }  
        
    }  
}