
public class Customer {
	String maKH,  hoTen, diaChi;
	long doanhSo;
	
	public Customer(String maKH, String hoTen, String diaChi, long doanhSo) {
		this.maKH = maKH;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.doanhSo = doanhSo;
	}
	
	public String toString() {
		return "- maKH: " + maKH + "  - hoTen: " + hoTen + "  - diaChi: " + diaChi + "  - doanhSo: " +doanhSo +"\n";
	}
	public Customer() {
		
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public long getDoanhSo() {
		return doanhSo;
	}

	public void setDoanhSo(long doanhSo) {
		this.doanhSo = doanhSo;
	}
	
}
