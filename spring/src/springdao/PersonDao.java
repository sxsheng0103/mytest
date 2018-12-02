package springdao;

import java.util.List;

public interface PersonDao {

	List<Person> findById(Integer id);

}
