package test1;

import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import ejbtest1.HelloWorld;
import ejbtest1.Other;
import ejbtest1.impl.OtherBean;

public class EJBClient {
	public static void main(String[] args) {
//		Properties props = new Properties();
//		props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
//		props.setProperty("java.naming.provider.url", "localhost:1099");
		try {
			InitialContext ctx = new InitialContext();
			
			HelloWorld helloworld = (HelloWorld) ctx.lookup("HelloWorldBean/remote");
			System.out.println(helloworld.sayHello("丁升"));
			Other other = (Other) ctx.lookup("OtherBean/remote");
			System.out.println(other.sayMe());
		}catch(NamingException e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
