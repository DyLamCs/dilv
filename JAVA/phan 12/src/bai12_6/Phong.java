package bai12_6;

public abstract class Phong {
	private String   maPhong, loaiPhong, trangThai;
	private long giaThue;
	
	abstract String inThongTinPhong();
	
//	Phương thức khởi tạo không đối số
	public Phong() {
		
	}
//	Phương thức khởi tạo co đối số
	public Phong(String maPhong, String loaiPhong, String trangThai, long giaThue) {
		this.maPhong = maPhong;
		this.loaiPhong = loaiPhong;
		this.trangThai = trangThai;
		this.giaThue = giaThue;
}
//	get/set
	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public String getLoaiPhong() {
		return loaiPhong;
	}

	public void setLoaiPhong(String loaiPhong) {
		this.loaiPhong = loaiPhong;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public long getGiaThue() {
		return giaThue;
	}

	public void setGiaThue(long giaThue) {
		this.giaThue = giaThue;
	}

	@Override
	public String toString() {
		return "Phong [maPhong=" + maPhong + ", loaiPhong=" + loaiPhong + ", trangThai=" + trangThai + ", giaThue="
				+ giaThue + "]";
	}

	
	
}
