package bai12_11;

public class PhongTro implements Phong, HoaDon {
	private String maPhong, giaDien, giaNuoc;
	private long idHoaDon;
	public PhongTro() {
		
	}
	
	

	public PhongTro(String maPhong, String giaDien, String giaNuoc, long idHoaDon) {
		this.maPhong = maPhong;
		this.giaDien = giaDien;
		this.giaNuoc = giaNuoc;
		this.idHoaDon = idHoaDon;
	}
	



	public String getMaPhong() {
		return maPhong;
	}



	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}



	public String getGiaDien() {
		return giaDien;
	}



	public void setGiaDien(String giaDien) {
		this.giaDien = giaDien;
	}



	public String getGiaNuoc() {
		return giaNuoc;
	}



	public void setGiaNuoc(String giaNuoc) {
		this.giaNuoc = giaNuoc;
	}
	
	
	@Override
	public String inThongTinPhong() {
		// TODO Auto-generated method stub
		return "PhongTro [maPhong=" + maPhong + ", giaDien=" + giaDien + ", giaNuoc=" + giaNuoc + "]";
	}



	@Override
	public String inThongTinHoaDon() {
		return "PhongKhachSan [idHoaDon=" + idHoaDon + "]";
	}
	
	

}
