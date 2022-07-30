package bai12_6;

public class Main {

	public static void main(String[] args) {
		DiaDiem nha = new Nha("Can Tho");
		DiaDiem khachsan = new KhachSan("TP.HCM", "KING");
		DiaDiem nhatro = new NhaTro("Hanh Phuc", "Can Tho");
		
		Phong phongtro = new PhongTro("101", "VIP", "Trống", 1500000, 4000, 8000);
		Phong phongkhachsan = new PhongKhachSan("101", "Tong Thong", "Trống", 10000000);
		
		System.out.println(">>>---Dia chi---<<< ");
		System.out.println(nha.inDiaChi());
		System.out.println(khachsan.inDiaChi());
		System.out.println(nhatro.inDiaChi());
		
		System.out.println(">>>---Thong tin phong---<<< ");
		System.out.println(phongtro.inThongTinPhong());
		System.out.println(phongkhachsan.inThongTinPhong());
	}

}
