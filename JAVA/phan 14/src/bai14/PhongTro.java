package bai14;

public class PhongTro {
	private long id;
	private String maPhong;
	private long giaThang, giaDien, giaNuoc;
	public PhongTro() {
		
	}
	public PhongTro(long id, String maPhong, long giaThang, long giaDien, long giaNuoc) {
		this.id = id;
		this.maPhong = maPhong;
		this.giaThang = giaThang;
		this.giaDien = giaDien;
		this.giaNuoc = giaNuoc;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	public long getGiaThang() {
		return giaThang;
	}
	public void setGiaThang(long giaThang) {
		this.giaThang = giaThang;
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
	@Override
	public String toString() {
		return "PhongTro [id=" + id + ", maPhong=" + maPhong + ", giaThang=" + giaThang + ", giaDien=" + giaDien
				+ ", giaNuoc=" + giaNuoc + "]" +"\n";
	}
	
	
}

