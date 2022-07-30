package bai10;

public class DangKy {
	private String  idDangKy, idKhachHang, idPhong;
	private long tienCoc;	
	private String ngayDangKy, ngayGioDen, ngayGioDi;
	private int soLuongNguoiLon, soLuongTreEm;
	private boolean trangThai=true;
	public DangKy() {
		
	}
	public DangKy(String idDangKy, String idKhachHang, String idPhong, long tienCoc, String ngayDangKy,
			String ngayGioDen, String ngayGioDi, int soLuongNguoiLon, int soLuongTreEm) {
		this.idDangKy = idDangKy;
		this.idKhachHang = idKhachHang;
		this.idPhong = idPhong;
		this.tienCoc = tienCoc;
		this.ngayDangKy = ngayDangKy;
		this.ngayGioDen = ngayGioDen;
		this.ngayGioDi = ngayGioDi;
		this.soLuongNguoiLon = soLuongNguoiLon;
		this.soLuongTreEm = soLuongTreEm;
	}
	public String getIdDangKy() {
		return idDangKy;
	}
	public void setIdDangKy(String idDangKy) {
		this.idDangKy = idDangKy;
	}
	public String getIdKhachHang() {
		return idKhachHang;
	}
	public void setIdKhachHang(String idKhachHang) {
		this.idKhachHang = idKhachHang;
	}
	public String getIdPhong() {
		return idPhong;
	}
	public void setIdPhong(String idPhong) {
		this.idPhong = idPhong;
	}
	public long getTienCoc() {
		return tienCoc;
	}
	public void setTienCoc(long tienCoc) {
		this.tienCoc = tienCoc;
	}
	public String getNgayDangKy() {
		return ngayDangKy;
	}
	public void setNgayDangKy(String ngayDangKy) {
		this.ngayDangKy = ngayDangKy;
	}
	public String getNgayGioDen() {
		return ngayGioDen;
	}
	public void setNgayGioDen(String ngayGioDen) {
		this.ngayGioDen = ngayGioDen;
	}
	public String getNgayGioDi() {
		return ngayGioDi;
	}
	public void setNgayGioDi(String ngayGioDi) {
		this.ngayGioDi = ngayGioDi;
	}
	public int getSoLuongNguoiLon() {
		return soLuongNguoiLon;
	}
	public void setSoLuongNguoiLon(int soLuongNguoiLon) {
		this.soLuongNguoiLon = soLuongNguoiLon;
	}
	public int getSoLuongTreEm() {
		return soLuongTreEm;
	}
	public void setSoLuongTreEm(int soLuongTreEm) {
		this.soLuongTreEm = soLuongTreEm;
	}
	
	
	public boolean isTrangThai() {
		return trangThai;
	}
	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}
	@Override
	public String toString() {
		return "DangKy [idDangKy=" + idDangKy + ", idKhachHang=" + idKhachHang + ", idPhong=" + idPhong + ", tienCoc="
				+ tienCoc + ", ngayDangKy=" + ngayDangKy + ", ngayGioDen=" + ngayGioDen + ", ngayGioDi=" + ngayGioDi
				+ ", soLuongNguoiLon=" + soLuongNguoiLon + ", soLuongTreEm=" + soLuongTreEm + ", trangThai=" + trangThai
				+ "]";
	}
	
	
	
}
