package bai12_6;

public abstract class DiaDiem {
	private String diaChi;
	
	abstract String inDiaChi();

	public DiaDiem() {
		
	}
	
	public DiaDiem(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	@Override
	public String toString() {
		return "DiaDiem [diaChi=" + diaChi + "]";
	}
	
	
	
	
}
