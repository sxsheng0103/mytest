package ejbtest1;

import javax.ejb.Local;

@Local(OtherLocal.class)
public interface OtherLocal extends Other{
}
