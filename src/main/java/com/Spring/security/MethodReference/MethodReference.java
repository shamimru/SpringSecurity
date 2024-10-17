package com.Spring.security.MethodReference;

public class MethodReference {

	public static void m1() {
		for(int i=0;i<=10;i++) {
			System.out.println("The value is "+i);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
//		Runnable r=()->{
//			
//		};
		
		Runnable r1=MethodReference::m1;
		Thread t=new Thread(r1);
		t.start();
		
		System.out.println("..................................");
		
		for(int i=0;i<=10;i++) {
			System.out.println("The value of main is "+i);
		}

	}

}
