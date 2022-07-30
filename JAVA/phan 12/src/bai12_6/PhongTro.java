package bai12_6;

public class PhongTro extends Phong {
	private long giaDien, giaNuoc;
	
	public PhongTro() {
		
	}
	
	
	public PhongTro(String maPhong, String loaiPhong, String trangThai, long giaThue, long giaDien, long giaNuoc) {
		super(  maPhong,  loaiPhong,  trangThai, giaThue);
		this.giaDien = giaDien;
		this.giaNuoc = giaNuoc;
	}

	
	String inThongTinPhong() {
		
		return "PhongTro [MaPhong:" + getMaPhong() + ", LoaiPhong: " + getLoaiPhong() + ",TrangThai: "
		+ getTrangThai() + ", GiaThue: " + getGiaThue() + ", giaDien: " + giaDien + ", giaNuoc: " + giaNuoc
		+ "]";
		
	}
	

	public long getGiaDien() {
		return giaDien;
	}


	public void setGiaDien(long giaDien) {
		this.giaDien = giaDien;
	}


	public long getGiaNuoc() {
		return giaNuoc;
	}


	public void setGiaNuoc(long giaNuoc) {
		this.giaNuoc = giaNuoc;
	}
	
	
	
}
