package testrmi.server.imp;

import testrmi.server.RmiService;

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