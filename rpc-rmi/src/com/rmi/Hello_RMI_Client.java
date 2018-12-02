package com.rmi;

import java.rmi.Naming;
public class Hello_RMI_Client {
    public static void main(String[] args) {
        try {
           //IHello hello = (IHello) Naming.lookup("rmi://localhost:1099/hello");
            IHello hello = (IHello) Naming.lookup("rmi://localhost:1099/hello");
                System.out.println(hello.sayHello("zhangxianxin"));
                System.out.println( Naming.lookup("rmi://localhost:8080/soap/DemoSend"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}