
public class MyProfile {
	String hoTen = "Lam Van Di";
	String ngaySinh = "04/08/1998";
	
	String diaChi = "Rach Gia - Kien Giang";
	long soDT = 845000408;
	
	public void myInfo(){
		System.out.println("Ho va ten: " + hoTen);
		System.out.println("Ngay sinh: " + ngaySinh);
		System.out.println("Dia chi: " + diaChi);
		System.out.println("So dien thoai: " +soDT);
	}
	
	public static void main(String[] args) {
		MyProfile m = new MyProfile();
		m.myInfo();
	}

}
