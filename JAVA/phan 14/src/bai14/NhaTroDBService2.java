package bai14;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.Result;

public class NhaTroDBService2 {
	
	public int themPhong(PhongEntity phong) {
		
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			Statement state = conn.createStatement(); 
//			Statement cung cấp các phương thức để thực thi các câu lệnh truy vấn với cơ sở dữ liệu SQL
//			Statement cung cấp phương thức để tạo ra đối tượng ResultSet.
			String sql = "INSERT INTO phong(id, maPhong, tenPhong, loaiPhong, dienTich, trangThai) VALUES ("
					+ phong.getId() + ",'" + phong.getMaPhong() + "','" + phong.getTenPhong() + "', '"
					+ phong.getLoaiPhong() + "'," + phong.getDienTich() + "," + phong.getTrangThai() + ")";
			
			state.executeUpdate(sql); //executeUpdate su dung chung cho lenh Insert, Update, Delete
			return 0;		
			
		} catch (Exception e) {
			e.printStackTrace();
			return 1;
		}
		
	}
	
	public PhongEntity getPhong(String maPhong) {
		PhongEntity phong = new PhongEntity();
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection(); //tao ket noi
			Statement state = conn.createStatement();
		
			
			String sql = "SELECT * FROM phong WHERE maPhong='" + maPhong + "'";
//			ResultSet duy trì một con trỏ trỏ đến một hàng của một bảng
			ResultSet rs = state.executeQuery(sql);//executeQuery được sử dụng để thực hiện truy vấn SELECT. Nó trả về đối tượng của ResultSet.
			
			while(rs.next()) {
				phong.setId(rs.getLong("id"));
				phong.setMaPhong(rs.getString("maPhong"));
				phong.setTenPhong(rs.getString("tenPhong"));
				phong.setLoaiPhong(rs.getString("loaiPhong"));
				phong.setDienTich(rs.getDouble("dienTich"));
				phong.setTrangThai(rs.getInt("trangThai"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return phong;
		
	}
	
//	In danh sach phong trong DB
	public ArrayList<PhongEntity> getPhong() {
		ArrayList<PhongEntity> danhSachPhong = new ArrayList<PhongEntity>();
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			Statement state = conn.createStatement();

			String sql = "SELECT * FROM phong ";

			ResultSet rs = state.executeQuery(sql);
			while (rs.next()) {
				
				PhongEntity phong = new PhongEntity();
				
				phong.setId(rs.getLong("id"));
				phong.setMaPhong(rs.getString("maPhong"));
				phong.setTenPhong(rs.getString("tenPhong"));
				phong.setLoaiPhong(rs.getString("loaiPhong"));
				phong.setDienTich(rs.getDouble("dienTich"));
				phong.setTrangThai(rs.getInt("trangThai"));
				
				danhSachPhong.add(phong);
				
			}
			
		} catch (Exception e) {
			System.out.println("Khong tim thay");
		}
		System.out.println("Danh sach phong:");
		return danhSachPhong; 
		
	}
	
	public static void main(String[] args) {
		NhaTroDBService2 nhatroDB = new NhaTroDBService2();
		
//		PhongEntity phong1 = new PhongEntity(1, "G01", "Phong Thong Thong", "phong VIP", 100, 1);
//		PhongEntity phong2 = new PhongEntity(2, "G02", "Phong thuong gia", "phong VIP", 50, 2);
//		PhongEntity phong3 = new PhongEntity(3, "G03", "Phong giuong doi", "phong VIP", 50, 3);
//		System.out.println(nhatroDB.themPhong(phong1));
//		System.out.println(nhatroDB.themPhong(phong2));
//		System.out.println(nhatroDB.themPhong(phong3));
		
		System.out.println(nhatroDB.getPhong("G01"));
		
//		System.out.println(nhatroDB.getPhong());
		
	}
}
