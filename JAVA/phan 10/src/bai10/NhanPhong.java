package bai10;

public class NhanPhong {
	
	private String ngayGioNhan;
	private String idDangKy;
	private String idPhong;
	
	public NhanPhong() {
	}

	public NhanPhong(String ngayGioNhan, String idDangKy, String idPhong) {
		this.ngayGioNhan = ngayGioNhan;
		this.idDangKy = idDangKy;
		this.idPhong = idPhong;
	}

	public String getNgayGioNhan() {
		return ngayGioNhan;
	}

	public void setNgayGioNhan(String ngayGioNhan) {
		this.ngayGioNhan = ngayGioNhan;
	}

	public String getIdDangKy() {
		return idDangKy;
	}

	public void setIdDangKy(String idDangKy) {
		this.idDangKy = idDangKy;
	}

	public String getIdPhong() {
		return idPhong;
	}

	public void setIdPhong(String idPhong) {
		this.idPhong = idPhong;
	}

	@Override
	public String toString() {
		return "NhanPhong [ngayGioNhan=" + ngayGioNhan + ", idDangKy=" + idDangKy + ", idPhong=" + idPhong + "]";
	}
	
	
}
