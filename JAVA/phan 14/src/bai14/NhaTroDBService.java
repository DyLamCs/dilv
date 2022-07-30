package bai14;

import java.awt.Taskbar.State;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.Result;

public class NhaTroDBService {
//	Nhap phong
	public int themPhong(PhongEntity phong) {
		
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
//			Statement cung cấp các phương thức để thực thi các câu lệnh truy vấn với cơ sở dữ liệu SQL
//			Statement cung cấp phương thức để tạo ra đối tượng ResultSet.
			
			String sql1 = "SELECT * from phong where maPhong = '" + phong.getMaPhong() +"'"; 
			
			Statement state = conn.createStatement(); //tao 1 state
			if(state.executeQuery(sql1).next()) { // state.executeQuery = Resulset thuc hien cua len truy van sql1 neu co tra ve 1
				return 1;
			}
			
			String sql = "INSERT INTO phong(id, maPhong, tenPhong, loaiPhong, dienTich, trangThai) "
					+ "VALUES (?, ?, ?, ?, ?, ? )";		
			
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setLong(1, phong.getId());
			ps.setString(2, phong.getMaPhong());
			ps.setString(3, phong.getTenPhong());
			ps.setString(4, phong.getLoaiPhong());
			ps.setDouble(5, phong.getDienTich());
			ps.setInt(6, phong.getTrangThai());
			
			
			ps.executeUpdate(); //executeUpdate su dung chung cho lenh Insert, Update, Delete
			return 0;		
			
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		
	}
//	Lay ra phong bang maPhong
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
	
//	ArrayList<PhongEntity> getPhong(int trangThai): Trả về danh sách các phòng có
//	trạng thái trangThai đang có trong csdl
	public ArrayList<PhongEntity> getPhong(int trangThai) throws ClassNotFoundException, SQLException{ // ArrayList<PhongEntity> kieu du lieu tra ve
		
		ArrayList<PhongEntity> danhSachPhong = new ArrayList<PhongEntity>();
		
		Connection conn = MySQLConnUtils.getMySQLConnection();
		
		String sql = "SELECT * FROM phong where trangThai='"+trangThai+"'"; 
		Statement state = conn.createStatement();
		ResultSet rs = state.executeQuery(sql);
		while(rs.next()) {
			PhongEntity phong = new PhongEntity();
			
			phong.setId(rs.getLong("id"));
			phong.setMaPhong(rs.getString("maPhong"));
			phong.setTenPhong(rs.getString("tenPhong"));
			phong.setLoaiPhong(rs.getString("loaiPhong"));
			phong.setDienTich(rs.getDouble("dienTich"));
			phong.setTrangThai(rs.getInt("trangThai")); //ten cot
			
			danhSachPhong.add(phong);						
			
		}
		return danhSachPhong;
					
	}
	
//	int capNhatTrangThai(String maPhong, int trangThai):
//		Cập nhật phòng có mã là maPhong với trạng thái mới là trangThai
//		Hàm trả về 0 nếu cập nhật thành công, trả về 1 nếu mã phòng không có
	
	public int capNhatTrangThai(String maPhong, int trangThai) throws ClassNotFoundException, SQLException {
		
		Connection conn = MySQLConnUtils.getMySQLConnection(); // tao ket noi
		
		String sql = "SELECT * from phong where maPhong = '"+maPhong+"'"; 
		String sql1 = "update phong set trangThai= "+trangThai+" where maPhong= '"+maPhong+"'"; 
		
		Statement state = conn.createStatement(); //tao 1 state
		
		if(state.executeQuery(sql).next()) { // state.executeQuery = Resulset thuc hien cua len truy van sql1 neu co tra ve 1
			state.executeUpdate(sql1);
			return 0;
			
		}
		return 1;
						
	}
	
	public ArrayList<PhongEntity> sapXepPhong() {
		ArrayList<PhongEntity> danhSachPhong = new ArrayList<PhongEntity>();
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			Statement state = conn.createStatement();

			String sql = "select * from phong order by maPhong asc";

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
			e.printStackTrace();
		}
		System.out.println("Danh sach phong:");
		return danhSachPhong; 
		
		
	}
	
//	Bai 4
	public int themPhongTro(PhongTro phong) throws ClassNotFoundException, SQLException {
		Connection conn = MySQLConnUtils.getMySQLConnection();
		
//		kiem tra phong tro co ton tai hay chua?
		String sql = "SELECT * from phongtro where maPhong = '" + phong.getMaPhong() +"'";
		Statement state = conn.createStatement();
		if(state.executeQuery(sql).next()) {
			return 1;  //da ton tai
		}
//		Tien thanh them phong tro
		String sql1 = "INSERT INTO phongtro(id, maPhong, giaThang, giaDien, giaNuoc) "
				+ "VALUES (?, ?, ?, ?, ? )";
		
		PreparedStatement ps = conn.prepareStatement(sql1);
		
		ps.setInt(1, (int) phong.getId());
		ps.setString(2, phong.getMaPhong());
		ps.setLong(3, phong.getGiaThang());
		ps.setLong(4, phong.getGiaDien());
		ps.setLong(5, phong.getGiaNuoc());
		
		ps.executeUpdate();
		return 0; // them thanh cong
				
	}
	
	public ArrayList<PhongTro> getPhongTro() {
		ArrayList<PhongTro> danhSachPhongTro = new ArrayList<PhongTro>();
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			Statement state = conn.createStatement();

			String sql = "SELECT * FROM phongtro ";

			ResultSet rs = state.executeQuery(sql);
			while (rs.next()) {
				
				PhongTro phong = new PhongTro();
				
				phong.setId(rs.getLong("id"));
				phong.setMaPhong(rs.getString("maPhong"));
				phong.setGiaThang(rs.getLong("giaThang"));
				phong.setGiaDien(rs.getLong("giaDien"));
				phong.setGiaNuoc(rs.getLong("giaNuoc"));
				
				
				danhSachPhongTro.add(phong);
				
			}
			
		} catch (Exception e) {
			System.out.println("Khong tim thay");
		}
		System.out.println("Danh sach phong:");
		return danhSachPhongTro; 
		
	}
	
	
	
//	int capNhatGia(String maPhong, long giaThang, long giaDien, long giaNuoc):
//		Cập nhật giá phòng, giá điện và giá nước. Nếu giá mới là 0 thì giữa nguyên giá cũ
//		Hàm trả về 0 nếu cập nhật thành công, trả về 1 nếu mã phòng không có
	
	public int capNhatGia(String maPhong, long giaThang, long giaDien, long giaNuoc) throws ClassNotFoundException, SQLException {
		Connection conn = MySQLConnUtils.getMySQLConnection(); //ket noi
		
		String sql = "SELECT * from phongtro where maPhong = '"+maPhong+"'"; 
		String sql1 = "update phongtro set giaThang= "+giaThang+", giaDien= "+giaDien+",giaNuoc= "+giaNuoc+" where maPhong= '"+maPhong+"'";
		
		Statement state = conn.createStatement();
		if (state.executeQuery(sql).next()) {
			state.executeUpdate(sql1);
			return 0;
		}
		return 1;
		

					
	}
//	ArrayList<PhongTro> getPhongTro(): Trả về danh sách các phòng đang có trong csdl
	
	public ArrayList<PhongTro> sapXepPhongTro(){
		ArrayList<PhongTro> danhSachPhongTro = new ArrayList<PhongTro>();
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			Statement state = conn.createStatement();

			String sql = "select * from phongtro order by maPhong asc";

			ResultSet rs = state.executeQuery(sql);
			while (rs.next()) {
				
				PhongTro phong = new PhongTro();
				
				phong.setId(rs.getLong("id"));
				phong.setMaPhong(rs.getString("maPhong"));
				phong.setGiaThang(rs.getLong("giaThang"));
				phong.setGiaDien(rs.getLong("giaDien"));
				phong.setGiaNuoc(rs.getLong("giaNuoc"));
				
				danhSachPhongTro.add(phong);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Danh sach phong:");
		return danhSachPhongTro; 
		
	}
//	Sap xep phong tro
	
	
	
	
	
}
