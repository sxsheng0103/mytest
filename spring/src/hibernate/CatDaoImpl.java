package hibernate;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
public class CatDaoImpl extends HibernateDaoSupport implements ICatDao{ 
		private DataSource dataSource;
		private SessionFactory sessionFactory;
	   public void createCat(Cat cat){ 
	       this.getHibernateTemplate().persist(cat); 
	   } 
	   public List<Cat> listCats(){ 
	       return (List<Cat>) this.getHibernateTemplate().find("from person"); 
	   } 
	   public int getCatsCount(){ 
	       Number n = (Number)this.getSessionFactory().getCurrentSession().createQuery("selectcount(c) from Cat c").uniqueResult(); 
	       return n.intValue(); 
	   } 
	   public Cat findCatByName(String name){ 
	       List<Cat> catList =(List<Cat>) this.getHibernateTemplate().find("select c from Cat where c.name = ?",name); 
	       if(catList.size()>0) 
	          return catList.get(0); 
	       return null; 
	   } 
	   public void setDataSource(DataSource dataSource) {
	        this.dataSource = dataSource;
	   }
	}