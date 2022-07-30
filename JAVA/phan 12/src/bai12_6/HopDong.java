package bai12_6;

public abstract class HopDong {
	private String idHopDong, ngayVao, ngayRa;
	
	abstract void inHopDong();
	
	public HopDong() {
		
	}

	public HopDong(String idHopDong, String ngayVao, String ngayRa) {
		this.idHopDong = idHopDong;
		this.ngayVao = ngayVao;
		this.ngayRa = ngayRa;
	}

	public String getIdHopDong() {
		return idHopDong;
	}

	public void setIdHopDong(String idHopDong) {
		this.idHopDong = idHopDong;
	}

	public String getNgayVao() {
		return ngayVao;
	}

	public void setNgayVao(String ngayVao) {
		this.ngayVao = ngayVao;
	}

	public String getNgayRa() {
		return ngayRa;
	}

	public void setNgayRa(String ngayRa) {
		this.ngayRa = ngayRa;
	}

	@Override
	public String toString() {
		return "HopDong [idHopDong=" + idHopDong + ", ngayVao=" + ngayVao + ", ngayRa=" + ngayRa + "]";
	}
	
	
	
}
