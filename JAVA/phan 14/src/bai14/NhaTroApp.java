package bai14;

import java.sql.SQLException;

public class NhaTroApp {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		NhaTroDBService nhatroDB = new NhaTroDBService();
//		Them moi 3 phong
//		PhongTro phong1 = new PhongTro(1, "G01", 2000000, 4000, 8000);
//		PhongTro phong3 = new PhongTro(3, "G03", 3000000, 4000, 8000);
//		PhongTro phong2 = new PhongTro(2, "G02", 2500000, 4000, 8000);
//		System.out.println(nhatroDB.themPhongTro(phong1));
//		System.out.println(nhatroDB.themPhongTro(phong3));
//		System.out.println(nhatroDB.themPhongTro(phong2));

//		In danh sach phong tro dang co trong DB
//		System.out.println(nhatroDB.getPhongTro());s
		
//		Sap xep phong tro
//		System.out.println(nhatroDB.sapXepPhongTro());
		
//		Cap nhat gia
		System.out.println(nhatroDB.capNhatGia("G01", 5000000, 5000, 10000));

	}

}
