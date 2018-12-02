package ejbtest1.impl;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import ejbtest1.Other;
import ejbtest1.OtherLocal;
@Stateless
@Remote(Other.class)
@Local(OtherLocal.class)
public class OtherBean implements Other,OtherLocal{

	@Override
	public String sayMe() {
		// TODO Auto-generated method stub
		return "other";
	}

}
