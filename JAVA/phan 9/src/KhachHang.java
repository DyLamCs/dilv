
public class KhachHang {
	private long id, doanhSo;
	private String makh, ten , diaChi;
	
	public KhachHang() {
		
	}
// 	Thuộc tính thuộc lớp (static ) có tên lastId (long), với giá trị khởi tạo mặc định là 0 	
	public static long lastId = 0; 
//	Phương thức thuộc lớp (static) increaseId() 
//	để tăng lastId lên 1 đơn vị và trả về giá trị mới tăng này của lastId	
	public static long increaseId() {
		return lastId++;
	}
// 
	public KhachHang(String makh, String ten, String diaChi) {
		id = increaseId();
		this.makh = makh;
		this.ten = ten;
		this.diaChi = diaChi;
		doanhSo = 0;
	}
	
	
	
//	Tao phuong thuc set/get tu dong
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public long getDoanhSo() {
		return doanhSo;
	}


	public void setDoanhSo(long doanhSo) {
		this.doanhSo = doanhSo;
	}


	public String getMakh() {
		return makh;
	}


	public void setMakh(String makh) {
		this.makh = makh;
	}


	public String getTen() {
		return ten;
	}


	public void setTen(String ten) {
		this.ten = ten;
	}


	public String getDiaChi() {
		return diaChi;
	}


	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

// Phương thức khởi tạo KhachHang(id,makh,ten,diachi) để khởi tạo giá trị cho 4 thuộc tính, khởi tạo giá trị doanhSo là 0.
	public KhachHang(long id, String makh, String ten, String diaChi) {
		this.id = id;
		this.makh = makh;
		this.ten = ten;
		doanhSo = 0;
	}
//	Phương thức void info() để in thông tin chi tiết về khách hàng 	
	public void info() {
		System.out.println("ID: " + id + "\nmaKH: " + makh + "\nTen: " + ten + "\nDia Chi: " + diaChi + "\nDoanhSo: "+ doanhSo);
	}
// Phương thức void muaHang(int soTien) cộng thêm vào doanhSo lên một lượng soTien 
	public void muaHang(int soTien) {
		doanhSo = doanhSo + soTien;
	}
	
	
	
	

	public static void main(String[] args) {
		KhachHang kh1 = new KhachHang(1, "68", "Di Lâm", "Kiên Giang");
		kh1.info();
		System.out.println(">>---------------------<<");
		kh1.muaHang(100);
		kh1.info();

	}

}
