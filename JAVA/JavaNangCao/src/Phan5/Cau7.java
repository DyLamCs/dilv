package Phan5;

public class Cau7 {
	public static void main(String[] args) {
		try {
			chia2So(1, 0);
		} catch (MyException e) {
			
			System.out.println(e.getMessage());
		}
	}
	
	public static void chia2So(int a, int b) throws MyException {
		try{
			int kq = a / b;
		
		System.out.println(kq);
		}catch(Exception e) {
			throw new MyException("Loi chia cho 0 ");
		}
	}
}
