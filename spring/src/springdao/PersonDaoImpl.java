package springdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


public class PersonDaoImpl implements PersonDao {
    private DataSource dataSource; //引入datasource bean
    @Override
    public List<Person> findById(Integer id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Person> lp=new ArrayList<Person>();
        Person p=null;
        String sql="select * from person where id=?";
        Object [] params={id};
        //获取连接
        try {
            con=dataSource.getConnection();
            ps=con.prepareStatement(sql);
            if(params!=null){
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i+1, params[i]);
            }
            }
            if(id == null) {
            	ps=con.prepareStatement("select * from person");
            }
            rs=ps.executeQuery();
            if(rs!=null){
                while(rs.next()){
                	p=new Person();
                    p.setId(rs.getInt("id"));
                    p.setName(rs.getString("name"));
                    p.setAge(rs.getInt("age"));
                    lp.add(p);
                }
            }
            return lp;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            
                try {
                    if(rs!=null)
                    rs.close();
                    if(ps!=null)
                        ps.close();
                    if(con!=null)
                        con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
        return null;
    }
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

}