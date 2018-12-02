package ejbtest1.impl;

import javax.activation.DataSource;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TimerService;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ejbtest1.HelloWorld;
import ejbtest1.HelloWorldLocal;
import ejbtest1.Other;
@Stateless
@Remote(HelloWorld.class)
@Local(HelloWorldLocal.class)
public class HelloWorldBean implements HelloWorld,HelloWorldLocal {
	@EJB(beanName="OtherBean") Other other;
	String zrhq = "";
	@Resource TimerService timerService;
//	@Resource(mappedName="java:xxx") DataSource dataSource;
	@Override
	public String sayHello(String name) {
		// TODO Auto-generated method stub
		InitialContext ctx;
		try {
			zrhq = other.sayMe();
			ctx = new InitialContext();
			Other other = (Other) ctx.lookup("OtherBean/local");
			return name + "说：我想你,老婆!你到底在哪里"+"--还有"+other.sayMe()+"注入获取"+zrhq;
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name + "说：我想你,老婆!你到底在哪里"+"--还有";
	}
}
