package Phan6;

import java.util.ArrayList;

public class MyArrayList {
	public static void main(String[] args) {
		ArrayList<Object> mylist = new ArrayList<Object>();
		
		mylist.add(10);
		mylist.add(15.52);
		mylist.add(true);
		mylist.add("Hello IVS");
		

		System.out.println("Số nguyên: " + mylist.get(0));
		System.out.println("Số thực: " + mylist.get(1));
		System.out.println("Boolean: " + mylist.get(2));
		System.out.println("String: " + mylist.get(3));

		
		
	}
	
	
	
	
	
	

}
