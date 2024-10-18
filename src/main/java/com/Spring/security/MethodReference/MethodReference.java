//package com.Spring.security.MethodReference;
//
//interface inter_1 {
//	public void doSomething(int i, int j);
//}
//
//interface inter_2 {
//	Student doSomething(int i, String j);
//}
//
//
//
//class Student {
//	int id;
//	String name;
//
//	Student(int id, String name) {
//		this.id = id;
//		this.name = name;
//	}
//
//	@Override
//	public String toString() {
//		return "Student [id=" + id + ", name=" + name + "]";
//	}
//	
//	
//}
//
//
//
//public class MethodReference {
//
//	public void add(int i, int j) {
//		System.out.println("the sum is " + (i + j));
//	}
//
//	public void sub(int i, int j) {
//		System.out.println("the sum is " + (i - j));
//	}
//
////	public static void main(String... strings) {
//		MethodReference mr = new MethodReference();
//
//		inter_1 intr_1 = mr::add;
//		intr_1.doSomething(200, 20);
//
//		inter_1 intr_2 = mr::sub;
//		intr_2.doSomething(200, 20);
//		
//		
//		inter_2 st1=Student::new;
//		
//		Student doSomething = st1.doSomething(20, "shamim ahamed");
//		System.out.println(doSomething);
//		
//
//	}
//
//}
