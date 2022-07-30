package bai10;

public class DichVu {
	private int idDichVu;
	private String tenDichVu;
	private long giaDichVu;
	
	public DichVu() {
	}

	public DichVu(int idDichVu, String tenDichVu, long giaDichVu) {
		this.idDichVu = idDichVu;
		this.tenDichVu = tenDichVu;
		this.giaDichVu = giaDichVu;
	}

	public int getIdDichVu() {
		return idDichVu;
	}



	public void setIdDichVu(int idDichVu) {
		this.idDichVu = idDichVu;
	}



	public String getTenDichVu() {
		return tenDichVu;
	}



	public void setTenDichVu(String tenDichVu) {
		this.tenDichVu = tenDichVu;
	}



	public long getGiaDichVu() {
		return giaDichVu;
	}



	public void setGiaDichVu(long giaDichVu) {
		this.giaDichVu = giaDichVu;
	}

	@Override
	public String toString() {
		return "ID: "+idDichVu+" - Ten dich vu: "+tenDichVu+" - Gia: "+giaDichVu;
	}

	
	
}
