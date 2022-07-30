package bai10;

public class Phong {
	private String idPhong, loaiPhong;
	private boolean trangThaiPhong;
	private long giaPhong;
	
	public Phong() {
	}

	public String getIdPhong() {
		return idPhong;
	}

	public void setIdPhong(String idPhong) {
		this.idPhong = idPhong;
	}

	public String getLoaiPhong() {
		return loaiPhong;
	}

	public void setLoaiPhong(String loaiPhong) {
		this.loaiPhong = loaiPhong;
	}


	public boolean isTrangThaiPhong() {
		return trangThaiPhong;
	}

	public void setTrangThaiPhong(boolean trangThaiPhong) {
		this.trangThaiPhong = trangThaiPhong;
	}

	public long getGiaPhong() {
		return giaPhong;
	}

	public void setGiaPhong(long giaPhong) {
		this.giaPhong = giaPhong;
	}

	

	public Phong(String idPhong, String loaiPhong, boolean trangThaiPhong, long giaPhong) {
		this.idPhong = idPhong;
		this.loaiPhong = loaiPhong;
		this.trangThaiPhong = trangThaiPhong;
		this.giaPhong = giaPhong;
	}

	@Override
	public String toString() {
		return "Phong [idPhong=" + idPhong + ", loaiPhong=" + loaiPhong + ", trangThaiPhong=" + trangThaiPhong
				+ ", giaPhong=" + giaPhong + "]";
	}
	
	
}