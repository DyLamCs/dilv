package bai10;

public class TraPhong {
	private String idDangKy;
	private String ngayGioTra;
	
	public TraPhong() {
	}

	public TraPhong(String idDangKy, String ngayGioTra) {
		this.idDangKy = idDangKy;
		this.ngayGioTra = ngayGioTra;
	}

	public String getIdDangKy() {
		return idDangKy;
	}

	public void setIdDangKy(String idDangKy) {
		this.idDangKy = idDangKy;
	}

	public String getNgayGioTra() {
		return ngayGioTra;
	}

	public void setNgayGioTra(String ngayGioTra) {
		this.ngayGioTra = ngayGioTra;
	}

	@Override
	public String toString() {
		return "TraPhong [idDangKy=" + idDangKy + ", ngayGioTra=" + ngayGioTra + "]";
	}
	
	
}
