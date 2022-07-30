package bai14;

public class PhongEntity {
	private long id;
	private String maPhong;
	private String tenPhong;
	private String loaiPhong;
	private double dienTich;
	private int trangThai;
	
	public PhongEntity() {
		
	}
	
	public PhongEntity(int id,String maPhong, String tenPhong, String loaiPhong, double dienTich, int trangThai) {
		this.id = id;
		this.maPhong= maPhong;
		this.tenPhong = tenPhong;
		this.loaiPhong = loaiPhong;
		this.dienTich = dienTich;
		this.trangThai = trangThai;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long l) {
		this.id = l;
	}
	
	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public String getTenPhong() {
		return tenPhong;
	}

	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}

	public String getLoaiPhong() {
		return loaiPhong;
	}

	public void setLoaiPhong(String loaiPhong) {
		this.loaiPhong = loaiPhong;
	}

	public double getDienTich() {
		return dienTich;
	}

	public void setDienTich(double dienTich) {
		this.dienTich = dienTich;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	@Override
	public String toString() {
		return "PhongEntity id=" + id + ", maPhong=" + maPhong + ", tenPhong=" + tenPhong + ", loaiPhong=" + loaiPhong
				+ ", dienTich=" + dienTich + ", trangThai=" + trangThai + "\n";
	}

	
	
	
	
	
}
