package bai12_11;

public class PhongKhachSan implements Phong, HoaDon {
	private String maPhong, loaiPhong, giaPhong;
	private long  idHoaDon;
	
	public PhongKhachSan() {
		
	}

	public PhongKhachSan(String maPhong, String loaiPhong, String giaPhong) {
		this.maPhong = maPhong;
		this.loaiPhong = loaiPhong;
		this.giaPhong = giaPhong;
		this.idHoaDon = idHoaDon;
	}
	
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

	public String getGiaPhong() {
		return giaPhong;
	}

	public void setGiaPhong(String giaPhong) {
		this.giaPhong = giaPhong;
	}

	@Override
	public String inThongTinPhong() {
		// TODO Auto-generated method stub
		return "PhongKhachSan [maPhong=" + maPhong + ", loaiPhong=" + loaiPhong + ", giaPhong=" + giaPhong + "]";
	}

	@Override
	public String inThongTinHoaDon() {
		return "PhongKhachSan [idHoaDon=" + idHoaDon + "]";
	}



	

	


	

}
