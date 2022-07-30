package bai10;

public class ThanhToan {
	private long idThanhToan;
	private long idSuDungDichVu;
	private String idDangKy;
	private String ngayGioThanhToan;
	private long soTien;
	
	private static long lastId=0;
	
	public ThanhToan() {
	}

	public ThanhToan(long idSuDungDichVu, String idDangKy, String ngayGioThanhToan, long soTien) {
		this.idThanhToan = increaseId();
		this.idSuDungDichVu = idSuDungDichVu;
		this.idDangKy = idDangKy;
		this.ngayGioThanhToan = ngayGioThanhToan;
		this.soTien = soTien;
	}

	public static long increaseId() {
		return lastId++;
	}
	
	public long getIdThanhToan() {
		return idThanhToan;
	}

	public void setIdThanhToan(long idThanhToan) {
		this.idThanhToan = idThanhToan;
	}

	public long getIdSuDungDichVu() {
		return idSuDungDichVu;
	}

	public void setIdSuDungDichVu(long idSuDungDichVu) {
		this.idSuDungDichVu = idSuDungDichVu;
	}

	public String getIdDangKy() {
		return idDangKy;
	}

	public void setIdDangKy(String idDangKy) {
		this.idDangKy = idDangKy;
	}

	
	public String getNgayGioThanhToan() {
		return ngayGioThanhToan;
	}

	public void setNgayGioThanhToan(String ngayGioThanhToan) {
		this.ngayGioThanhToan = ngayGioThanhToan;
	}

	public long getSoTien() {
		return soTien;
	}

	public void setSoTien(long soTien) {
		this.soTien = soTien;
	}

	@Override
	public String toString() {
		return "ThanhToan [idThanhToan=" + idThanhToan + ", idSuDungDichVu=" + idSuDungDichVu + ", idDangKy=" + idDangKy
				+ ", ngayGioThanhToan=" + ngayGioThanhToan + ", soTien=" + soTien + "]";
	}

}
