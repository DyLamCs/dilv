package Phan6;

import java.util.ArrayList;


public class MyGenericArrayList {
	public static void main(String[] args) {
		// Tạo một mạng kiểu số nguyên
		ArrayList<Integer> mylist = new ArrayList<Integer>();
		
		// Loop 1-10 va thêm vào mãng đã tạo trước đó
		for(int i = 1; i <= 10; i++) {
			mylist.add(i);
		}
		
		// in mãng
		System.out.println(mylist);
		
		// in từng ký tự trong mãng
		for (Integer integer : mylist) {
			System.out.println(integer);
		}
	}

}
