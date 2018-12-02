package ejbtest1;

import javax.ejb.Remote;

@Remote(HelloWorld.class)
public interface HelloWorld {
	public String sayHello(String name);
}
