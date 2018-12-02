package BeanFactory;

/**
* Project Name:springAnalog
* File Name:ClassPathXmlApplicationContext.java
* Package Name:com.zsy.beanfactory
* Date:2015-11-20����09:43:20
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
    //����һ��filePath����
    private String filePath;
    
    //���ȶ���Map Ŀ������������Ķ���
    Map<String, Object> map = new HashMap<String, Object>();
    
    public ClassPathXmlApplicationContext(String filePath)
    {
        //��ȡ�����ļ�·��
        this.filePath = filePath;
        //��ʼ��
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
     * readFile:(��ȡ�ļ�). <br/>
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
        //����������dom4j������������dom4j���ص�ַ��http://sourceforge.net/projects/dom4j
        SAXReader reader = new SAXReader();
        //��ȡ���ڵ�
        Document document = reader.read(this.getClass().getClassLoader().getResourceAsStream(filePath));
        //��ȡbean���е�Ԫ��
        List<Element> list = document.selectNodes("/beans/bean");
        for (int i = 0; i < list.size(); i++)
        {
            //��ȡbean��id
            String id = list.get(i).attributeValue("id");
            //��ȡbean��classҲ�������·��
            String classpath = list.get(i).attributeValue("class");
            //���÷����ȡ����  �����ַ�ʽ����������ͨ�����ȫ��+����������
            Object object = Class.forName(classpath).newInstance();
            
            //�ŵ����Ƕ����map�� key =id ,vlaue =��ȡ�Ķ���Ϊ����getBean����ȡ�����ṩ����
            map.put(id, object);
        }
    }
    
    @Override
    public Object getBean(String id)
    {
        //�������id����ȡ���ڵĶ���ȿ�
        return map.get(id);
    }
    
}
