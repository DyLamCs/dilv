package bai10;

public class TienNghi {
	private String idTienNghi, idThietBi;
	private int soLuong;
	
	public TienNghi() {
	}
	public String getIdTienNghi() {
		return idTienNghi;
	}
	public void setIdTienNghi(String idTienNghi) {
		this.idTienNghi = idTienNghi;
	}
	public String getIdThietBi() {
		return idThietBi;
	}
	public void setIdThietBi(String idThietBi) {
		this.idThietBi = idThietBi;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public TienNghi(String idTienNghi, String idThietBi,int soLuong) {
		this.idTienNghi = idTienNghi;
		this.idThietBi = idThietBi;
		this.soLuong = soLuong;
		
	}
}
