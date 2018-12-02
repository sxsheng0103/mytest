package testrmi.client.imp;

import testrmi.client.RmiService;

public class RmiServiceImpl implements RmiService{  
    @Override  
    public String doWork() {  
        return "this message return from server";  
    }  
    @Override  
    public int add(int a, int b) {  
        return a+b;  
    }  
}