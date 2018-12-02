package BeanFactory;

/**
* Project Name:springAnalog
* File Name:ClassPathXmlApplicationContext.java
* Package Name:com.zsy.beanfactory
* Date:2015-11-20下午09:43:20
* Copyright (c) 2015, syzhao@zsy.com All Rights Reserved.
*
*/
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
 
public class ClassPathXmlApplicationContext implements BeanFactory
{
    //定义一个filePath变量
    private String filePath;
    
    //首先定义Map 目的来存放生产的对象
    Map<String, Object> map = new HashMap<String, Object>();
    
    public ClassPathXmlApplicationContext(String filePath)
    {
        //获取配置文件路径
        this.filePath = filePath;
        //初始化
        try
        {
            this.readFile();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    /**
     * readFile:(读取文件). <br/>
     * @author syzhao
     * @throws DocumentException 
     * @throws ClassNotFoundException 
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     * @since JDK 1.6
     */
    private void readFile()
        throws DocumentException, InstantiationException, IllegalAccessException, ClassNotFoundException
    {
        //接下来，用dom4j来解析，，，dom4j下载地址：http://sourceforge.net/projects/dom4j
        SAXReader reader = new SAXReader();
        //获取根节点
        Document document = reader.read(this.getClass().getClassLoader().getResourceAsStream(filePath));
        //获取bean所有的元素
        List<Element> list = document.selectNodes("/beans/bean");
        for (int i = 0; i < list.size(); i++)
        {
            //获取bean的id
            String id = list.get(i).attributeValue("id");
            //获取bean的class也就是类的路径
            String classpath = list.get(i).attributeValue("class");
            //利用反射获取对象  有三种方式，，，我们通过类的全名+包名来生成
            Object object = Class.forName(classpath).newInstance();
            
            //放到我们定义的map里 key =id ,vlaue =获取的对象，为下面getBean（）取对象提供条件
            map.put(id, object);
        }
    }
    
    @Override
    public Object getBean(String id)
    {
        //这里根据id来获取对于的对象既可
        return map.get(id);
    }
    
}
