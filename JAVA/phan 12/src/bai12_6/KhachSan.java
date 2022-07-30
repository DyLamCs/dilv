package bai12_6;

public class KhachSan extends DiaDiem  {
	private String tenKhachSan;
	
	public KhachSan() {
		
	}
	
	
	public KhachSan(String diaChi, String tenKhachSan) {
		super(diaChi);
		this.tenKhachSan = tenKhachSan;
	}
	


	public String getTenKhachSan() {
		return tenKhachSan;
	}


	public void setTenKhachSan(String tenKhachSan) {
		this.tenKhachSan = tenKhachSan;
	}


	@Override
	String inDiaChi() {
		// TODO Auto-generated method stub
		return "KhachSan [TenKhachSan: " + getTenKhachSan() + ",DiaChi: " + getDiaChi() + "]";
	}
	
	
	

}
