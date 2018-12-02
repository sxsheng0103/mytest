package ejbtest1;

import javax.ejb.Remote;

@Remote(Other.class)
public interface Other {
	public String sayMe();
}
