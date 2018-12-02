package ejbtest1;

import javax.ejb.Local;

@Local(HelloWorldLocal.class)
public interface HelloWorldLocal extends HelloWorld{
}
