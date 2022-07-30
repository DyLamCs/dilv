package bai10;

public class HuyDangKy {
	private long idHuy;
	private String idDangKy;
	private String ngayGioHuy;

	private static long lastId = 0;

	public HuyDangKy() {
	}

	public HuyDangKy(String idDangKy, String ngayGioHuy) {
		this.idHuy = increaseId();
		this.idDangKy = idDangKy;
		this.ngayGioHuy = ngayGioHuy;
	}

	public static long increaseId() {
		return lastId++;
	}

	public String getIdDangKy() {
		return idDangKy;
	}

	public void setIdDangKy(String idDangKy) {
		this.idDangKy = idDangKy;
	}

	public String getNgayGioHuy() {
		return ngayGioHuy;
	}

	public void setNgayGioHuy(String ngayGioHuy) {
		this.ngayGioHuy = ngayGioHuy;
	}

	public long getIdHuy() {
		return idHuy;
	}

	public void setIdHuy(long idHuy) {
		this.idHuy = idHuy;
	}

	@Override
	public String toString() {
		return "HuyDangKy [idHuy=" + idHuy + ", idDangKy=" + idDangKy + ", ngayGioHuy=" + ngayGioHuy + "]";
	}

}
