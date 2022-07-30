package Phan5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Cau1 {

	
	public void testFileNotFoundException() throws IOException {
		FileInputStream fileInput = null;
		fileInput = new FileInputStream("C:/mydata/phan5/test221.txt");
		fileInput.close();
	}
	
	@SuppressWarnings("unused")
	public void testFileNotFoundException1() {
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream("C:/mydata/phan5/test221.txt");
		} catch (FileNotFoundException e) {
			System.out.println("Loi");
		}
	}
	
	public static void main(String[] args) throws IOException {
		Cau1 cau1 = new Cau1();
		
		try {
			cau1.testFileNotFoundException();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
		cau1.testFileNotFoundException1();
	}
	
	

}
