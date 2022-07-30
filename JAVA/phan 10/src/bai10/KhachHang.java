package bai10;

public class KhachHang extends ConNguoi {
	private long idThanhToan;
	private String idKhachHang, emailKhachHang, quocTichKhachHang;
	public KhachHang() {
		
	}
	
	public KhachHang(long id, String hoTen, String gioiTinh, String ngaySinh, String diaChi, String soDienThoai, String cccd,
					long idThanhToan, String idKhachHang, String emailKhachHang, String quocTichKhachHang) {
		super(id, hoTen, gioiTinh, ngaySinh, diaChi, soDienThoai, cccd);
		this.idThanhToan = idThanhToan;
		this.idKhachHang = idKhachHang;
		this.emailKhachHang = emailKhachHang;
		this.quocTichKhachHang = quocTichKhachHang;
		
	}

	public long getIdThanhToan() {
		return idThanhToan;
	}

	public void setIdThanhToan(long idThanhToan) {
		this.idThanhToan = idThanhToan;
	}

	public String getIdKhachHang() {
		return idKhachHang;
	}

	public void setIdKhachHang(String idKhachHang) {
		this.idKhachHang = idKhachHang;
	}

	public String getEmailKhachHang() {
		return emailKhachHang;
	}

	public void setEmailKhachHang(String emailKhachHang) {
		this.emailKhachHang = emailKhachHang;
	}

	public String getQuocTichKhachHang() {
		return quocTichKhachHang;
	}

	public void setQuocTichKhachHang(String quocTichKhachHang) {
		this.quocTichKhachHang = quocTichKhachHang;
	}

	@Override
	public String toString() {
		return "KhachHang [idKhachHang=" + idKhachHang + ", HoTen=" + getHoTen() + ", GioiTinh="
				+ getGioiTinh() + ", NgaySinh=" + getNgaySinh() + "]";
	}

}
