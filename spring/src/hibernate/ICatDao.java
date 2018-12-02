package hibernate;

import java.util.List;

public interface ICatDao {
	   public void createCat(Cat cat); 
	   public List<Cat> listCats(); 
	   public int getCatsCount(); 
	   public Cat findCatByName(String name);
}
