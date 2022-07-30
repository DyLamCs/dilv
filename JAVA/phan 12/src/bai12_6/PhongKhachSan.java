package bai12_6;

public class PhongKhachSan extends Phong {
	
	public PhongKhachSan() {
		
	}

	public PhongKhachSan(String maPhong, String loaiPhong, String trangThai, long giaThue) {
		super(maPhong, loaiPhong, trangThai, giaThue);
		
	}

	@Override
	String inThongTinPhong() {
		return "PhongKhachSan [MaPhong: " + getMaPhong() + ", LoaiPhong: " + getLoaiPhong()
		+ ", TrangThai: " + getTrangThai() + ", GiaThue: " + getGiaThue() + "]";
		
	}
	
	
	
	
	
}
