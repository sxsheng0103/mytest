package com.testnative;
public class HelloWorld {
	public native String  displayHelloWorld(String abc);
	static
    {
//		 System.setProperty("java.library.path", "D:\\java\\EJB\\jpa\\src");
		 System.out.println(System.getProperty("java.library.path"));
		 System.loadLibrary("hello");
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String  accessNum = new HelloWorld().
				displayHelloWorld("abcde");
			System.out.println("½á¹ûÊÇ" + accessNum);
	}
}
	 