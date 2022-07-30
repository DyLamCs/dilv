package bai10;

public class SuDungDichVu {
	private long idSuDungDichVu;
	private String idKhachHang;
	private int idDichVu;
	private String ngaySuDung;
	private long donGiaDichVu;
	
	private static long lastId=0;
		
	public SuDungDichVu() {}

	public SuDungDichVu(String idKhachHang, int idDichVu, String ngaySuDung, long donGiaDichVu) {
		this.idSuDungDichVu = increaseId();
		this.idKhachHang = idKhachHang;
		this.idDichVu = idDichVu;
		this.ngaySuDung = ngaySuDung;
		this.donGiaDichVu = donGiaDichVu;
	}

	public static long increaseId() {
		return lastId++;
	}
	
	public long getIdSuDungDichVu() {
		return idSuDungDichVu;
	}

	public void setIdSuDungDichVu(long idSuDungDichVu) {
		this.idSuDungDichVu = idSuDungDichVu;
	}

	public String getIdKhachHang() {
		return idKhachHang;
	}

	public void setIdKhachHang(String idKhachHang) {
		this.idKhachHang = idKhachHang;
	}

	public int getIdDichVu() {
		return idDichVu;
	}

	public void setIdDichVu(int idDichVu) {
		this.idDichVu = idDichVu;
	}

	public String getNgaySuDung() {
		return ngaySuDung;
	}

	public void setNgaySuDung(String ngaySuDung) {
		this.ngaySuDung = ngaySuDung;
	}

	public long getDonGiaDichVu() {
		return donGiaDichVu;
	}

	public void setDonGiaDichVu(long donGiaDichVu) {
		this.donGiaDichVu = donGiaDichVu;
	}

	@Override
	public String toString() {
		return "SuDungDichVu [idSuDungDichVu=" + idSuDungDichVu + ", idKhachHang=" + idKhachHang + ", idDichVu="
				+ idDichVu + ", ngaySuDung=" + ngaySuDung + ", donGiaDichVu=" + donGiaDichVu + "]";
	}

	
}
