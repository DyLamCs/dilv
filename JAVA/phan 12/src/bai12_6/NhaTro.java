package bai12_6;

public class NhaTro extends DiaDiem {
	private String tenNhaTro;
	
	public NhaTro() {
		
	}
	
	

	public NhaTro(String tenNhaTro, String diaChi) {
		super(diaChi);
		this.tenNhaTro = tenNhaTro;
	}



	@Override
	String inDiaChi() {
		// TODO Auto-generated method stub
		return "NhaTro [TenNhaTro: " + getTenNhaTro() + ", DiaChi: " + getDiaChi() + "]";
	}
	
	public String getTenNhaTro() {
		return tenNhaTro;
	}



	public void setTenNhaTro(String tenNhaTro) {
		this.tenNhaTro = tenNhaTro;
	}
	
	
}
