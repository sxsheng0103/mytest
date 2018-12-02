package BeanFactory.Po;

import BeanFactory.inter.Person;

public class Student implements Person
{
    @Override
    public void work()
    {
        //输出一句话
        System.out.println("学生的工作是：认真学习！");
    }
    
}