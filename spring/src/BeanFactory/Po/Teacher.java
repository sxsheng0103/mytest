package BeanFactory.Po;

import BeanFactory.inter.Person;

public class Teacher implements Person
{
    @Override
    public void work()
    {
        //输出一句话
        System.out.println("老师的工作是：认真教书！！");
        
    }
    
}