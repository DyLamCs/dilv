package bai10;


public class NhanVien extends ConNguoi {
	private String idNhanVien, chucVuNhanVien;
	
	public NhanVien() {
		
	}
	
	public NhanVien(long id, String hoTen, String gioiTinh, String ngaySinh, String diaChi, String soDienThoai, String cccd,
					String idNhanVien, String chucVuNhanVien) {
		super(id, hoTen, gioiTinh, ngaySinh, diaChi, soDienThoai, cccd);
		this.idNhanVien = idNhanVien;
		this.chucVuNhanVien = chucVuNhanVien;
		
		
	}

	public String getIdNhanVien() {
		return idNhanVien;
	}

	public void setIdNhanVien(String idNhanVien) {
		this.idNhanVien = idNhanVien;
	}

	public String getChucVuNhanVien() {
		return chucVuNhanVien;
	}

	public void setChucVuNhanVien(String chucVuNhanVien) {
		this.chucVuNhanVien = chucVuNhanVien;
	}
	

	
	
}
