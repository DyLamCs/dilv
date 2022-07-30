package Phan5;

public class Cau2 {
	public static void main(String[] args) {
		try {
			throw new Exception("Truyền các tham số trong khi ném các Checked Exception trong Java");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
