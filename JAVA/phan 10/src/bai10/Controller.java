package bai10;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

import bai10.ConNguoi;
import bai10.DangKy;
import bai10.DichVu;
import bai10.KhachHang;
import bai10.Phong;
import bai10.SuDungDichVu;
import bai10.ThanhToan;
import bai10.ThietBi;
import bai10.TienNghi;
import bai10.TraPhong;

public class Controller {
	final String file_kh = "C://mydata/khachhang.txt";
	final String file_dk = "C://mydata/dangky.txt";

	int viTriKhachHang = 0;

	ArrayList<Integer> danhSachDichVu = new ArrayList<Integer>();
	ArrayList<DichVu> arrayListDichVu = new ArrayList<DichVu>();
	ArrayList<KhachHang> arrayListKhachHang = new ArrayList<KhachHang>();
	ArrayList<SuDungDichVu> arrayListSuDungDichVu = new ArrayList<SuDungDichVu>();
	ArrayList<TraPhong> arrayListTraPhong = new ArrayList<TraPhong>();
	ArrayList<DangKy> arrayListDangKy = new ArrayList<DangKy>();
	ArrayList<Phong> arrayListPhong = new ArrayList<Phong>();
	ArrayList<ThietBi> arrayListThietBi = new ArrayList<ThietBi>();
	ArrayList<TienNghi> arrayListTienNghi = new ArrayList<TienNghi>();

	// Khoi tao du lieu DichVu
	public void addDichVuDefault() {
		arrayListDichVu.add(new DichVu(1, "Bua sang", 100000));
		arrayListDichVu.add(new DichVu(2, "Bua trua", 100000));
		arrayListDichVu.add(new DichVu(3, "Bua chieu", 100000));
		arrayListDichVu.add(new DichVu(4, "Bar", 1000000));
		arrayListDichVu.add(new DichVu(5, "Spa", 300000));
		arrayListDichVu.add(new DichVu(6, "Giat, ui la", 20000));
		arrayListDichVu.add(new DichVu(7, "Dich vu phong", 100000));
		arrayListDichVu.add(new DichVu(8, "Be boi", 100000));
	}
	// Khoi tao du lieu Thiet bi
	public void addThietBiDefault() {
		arrayListThietBi.add(new ThietBi("ML","May lanh"));
		arrayListThietBi.add(new ThietBi("MQ","May quat"));
		arrayListThietBi.add(new ThietBi("MS","May Suoi"));
		arrayListThietBi.add(new ThietBi("MNL","May nong lanh"));
		arrayListThietBi.add(new ThietBi("TV","TiVi"));
		arrayListThietBi.add(new ThietBi("GD","Giuong don"));
		arrayListThietBi.add(new ThietBi("GDI","Giuong doi"));
		arrayListThietBi.add(new ThietBi("GE","Ghe ngoi"));
		arrayListThietBi.add(new ThietBi("TL","Tu lanh"));
	}
	
			// Khoi tao du lieu Phong
	public void addTienNghiDefault() {
		arrayListTienNghi.add(new TienNghi());
	}
			// Khoi tao du lieu Phong
	public void addPhongDefault() {
		arrayListPhong.add(new Phong());
	}

	// Xem danh sach khach hang
	public void xemDanhSachKhachHang() {
		for (KhachHang khachHang : arrayListKhachHang) {
			System.out.println(khachHang.toString());
		}
	}

	// Them khach hang
	public void themKhachHang() {
		KhachHang kh = new KhachHang();
		Scanner sc = new Scanner(System.in);
		try (FileOutputStream fos = new FileOutputStream(file_kh, true);
				DataOutputStream dos = new DataOutputStream(fos);) {
//			while(true) {
			System.out.println("Nhap thong tin con nguoi: ");

			System.out.println("Nhap ho ten: ");
			String hoten = sc.nextLine();
			kh.setHoTen(hoten);

			System.out.println("Nhap gioi tinh: ");
			String gioitinh = sc.nextLine();
			kh.setGioiTinh(gioitinh);

			System.out.println("Nhap ngay sinh: ");
			String ngaysinh = sc.nextLine();
			kh.setNgaySinh(ngaysinh);

			System.out.println("Nhap dia chi: ");
			String diachi = sc.nextLine();
			kh.setDiaChi(diachi);

			System.out.println("Nhap sdt: ");
			String sdt = sc.nextLine();
			kh.setSoDienThoai(sdt);

			System.out.println("Nhap CCCD: ");
			String cccd = sc.nextLine();
			kh.setCccd(cccd);

			System.out.print("nhap ma KH: ");
			String idKH = sc.nextLine();
			kh.setIdKhachHang(idKH);

			System.out.println("Email KH: ");
			String email = sc.nextLine();
			kh.setEmailKhachHang(email);

			System.out.println("Quoc tich KH: ");
			String quoctich = sc.nextLine();
			kh.setQuocTichKhachHang(quoctich);

			dos.writeUTF(hoten);
			dos.writeUTF(gioitinh);
			dos.writeUTF(ngaysinh);
			dos.writeUTF(diachi);
			dos.writeUTF(sdt);
			dos.writeUTF(cccd);
			dos.writeUTF(email);
			dos.writeUTF(quoctich);

			dos.close();
			fos.close();
//			}			
		}

		catch (IOException ie) {
			System.out.println(ie);
		}
	}

	// Chon khach hang
	public void chonKhachHang() {
		boolean check = false;
		int i = 0;
		do {
			System.out.print("Nhap ma Khach Hang: ");
			Scanner sc = new Scanner(System.in);
			String makh = sc.nextLine();
			for (KhachHang khachHang : arrayListKhachHang) {
				i++;
				if (khachHang.getIdKhachHang().equals(makh)) {
					System.out.println("Da xac nhan");
					viTriKhachHang = i;
					check = true;
					break;
				}
			}
			if (!check)
				System.out.println("Khong tim thay ma Khach Hang nay!");
		} while (!check);
	}

	// In danh sach phong
	public void inDanhSachPhong() {

	}

	// Nhap Dang Ky
	public void nhapDangKy() {
		KhachHang kh = new KhachHang();
		DangKy dk = new DangKy();

		try (FileOutputStream fos2 = new FileOutputStream(file_dk, true);
				DataOutputStream dos2 = new DataOutputStream(fos2);
				Scanner sc = new Scanner(System.in);) {
			while (true) {
				System.out.println("Nhap thong tin khach hang dang ky: ");

				System.out.println("Ma KH: ");
				String makh = sc.nextLine();
				if (makh.equals("0"))
					break;
				else {
					kh.setIdKhachHang(makh);

					System.out.println("Email KH: ");
					String email = sc.nextLine();
					kh.setEmailKhachHang(email);

					System.out.println("Quoc Tich: ");
					String quoctich = sc.nextLine();
					kh.setQuocTichKhachHang(quoctich);

					System.out.println("Ma dang ky: ");
					String madk = sc.nextLine();
					dk.setIdDangKy(madk);

					System.out.println("Ma Phong: ");
					String maphong = sc.nextLine();
					dk.setIdPhong(maphong);

					System.out.println("Ngay dang ky: ");
					String ngaydangky = sc.nextLine();
					dk.setNgayDangKy(ngaydangky);

					System.out.println("Ngay den yyyy-mm-dd hh:mm:ss ");
					String ngaygioden = nhap_kt_NgayGio(sc);
					dk.setNgayGioDen(ngaygioden);

					System.out.println("Ngay di yyyy-mm-dd hh:mm:ss ");
					String ngaygiodi = nhap_kt_NgayGio(sc);
					dk.setNgayGioDi(ngaygiodi);

					System.out.println("So luong nguoi lon: ");
					int slnl = nhap_kt_Int(sc);
					dk.setSoLuongNguoiLon(slnl);

					System.out.println("So luong tre em: ");
					int slte = nhap_kt_Int(sc);
					dk.setSoLuongTreEm(slte);

					System.out.println("tien dat coc: ");
					long tiencoc = nhap_kt_Long(sc);
					dk.setTienCoc(tiencoc);

					dos2.writeUTF(makh);
					dos2.writeUTF(email);
					dos2.writeUTF(quoctich);
					dos2.writeUTF(madk);
					dos2.writeUTF(maphong);
					dos2.writeUTF(ngaydangky);
					dos2.writeUTF(ngaygioden);
					dos2.writeUTF(ngaygiodi);
					dos2.writeInt(slnl);
					dos2.writeInt(slte);
					dos2.writeLong(tiencoc);

					dos2.close();
					fos2.close();
				}
			}
		} catch (IOException ie) {
			System.out.println(ie);
		}
	}

	// Xem dang ky
	public void xemDangKy() {
		try {
			FileInputStream fis = new FileInputStream(file_dk);
			DataInputStream dis = new DataInputStream(fis);
			
			while(dis.available() > 0) {
				DangKy dangky = new DangKy();
				
				
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Huy dang ky
	public void huyDangKy() {

	}

	// IN ra bang dich vu
	public void xemDichVu(ArrayList<DichVu> arrayListDichVu) {
		for (DichVu dichVu : arrayListDichVu) {
			System.out.println(dichVu.toString());
		}
	}

	// Thuc hien hanh dong goi dich vu cua kh
	public void goiDichVu() {
		int idDichVu;

		try (Scanner sc = new Scanner(System.in);) {
			do {
				System.out.print("Nhap stt dich vu: ");
				idDichVu = nhap_kt_Int(sc);
				if (idDichVu != 0) {
					danhSachDichVu.add(idDichVu);
				} else
					break;
			} while (true);
		} catch (Exception e) {
			System.out.print(e);
		}
		hoaDonDichVu();
	}

	// In hoa don su dung dich vu cua kh
	public void hoaDonDichVu() {
		System.out.println("Hoa Don Dich Vu");
		System.out.println("---------------");
		for (int idDichVu : danhSachDichVu) {
			DichVu dv = arrayListDichVu.get(idDichVu + 1);

			Date date = Calendar.getInstance().getTime();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
			String strDate = dateFormat.format(date);
			arrayListSuDungDichVu.add(new SuDungDichVu(arrayListKhachHang.get(viTriKhachHang).getIdKhachHang(),
					idDichVu, strDate, dv.getGiaDichVu()));
		}
		for (SuDungDichVu sddv : arrayListSuDungDichVu) {
			System.out.println(sddv.toString());
		}
	}

	// Thuc hien yeu cau thanh toan dich vu cua kh
	public void yeuCauThanhToan(ArrayList<SuDungDichVu> arrayListSuDungDichVu) {

		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String strDate = dateFormat.format(date);

		for (SuDungDichVu sddv : arrayListSuDungDichVu) {
			if (sddv.getIdKhachHang().equals(arrayListKhachHang.get(viTriKhachHang).getIdKhachHang())) {
				ThanhToan thanhToan = new ThanhToan();
				thanhToan.setNgayGioThanhToan(strDate);
				thanhToan.setIdSuDungDichVu(sddv.getIdSuDungDichVu());
				thanhToan.setSoTien(sddv.getDonGiaDichVu());
			}
		}
	}

	// Thuc hien yeu cau thanh toan phong cua kh
	public void yeuCauThanhToan() {
		boolean check = false;
		do {
			Scanner sc = new Scanner(System.in);
			String idDangKy = sc.nextLine();
			for (DangKy dangky : arrayListDangKy) {
				if (dangky.getIdDangKy().equals(idDangKy)) {
					check = true;
					traPhong(idDangKy);

					Date date = Calendar.getInstance().getTime();
					DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
					String strDate = dateFormat.format(date);

					ThanhToan thanhToan = new ThanhToan();
					thanhToan.setNgayGioThanhToan(strDate);
					thanhToan.setIdDangKy(idDangKy);
					for (Phong phong : arrayListPhong) {
						if (dangky.getIdPhong().equals(phong.getIdPhong())) {
							thanhToan.setSoTien(phong.getGiaPhong() - dangky.getTienCoc());
							break;
						}
					}
					System.out.println(thanhToan.toString());
					break;
				}
			}
			if (!check)
				System.out.println("Khong tim thay ma dang ky!");
		} while (!check);
	}

	// Kiem tra nhap Integer
	public int nhap_kt_Int(Scanner sc) {
		int i;
		do {
			if (sc.hasNextInt()) {
				i = sc.nextInt();
				sc.nextLine();
				break;
			} else {
				sc.nextLine();
				System.out.print("Chi duoc chua so! Nhap lai: ");
			}
		} while (true);
		return i;
	}

	// Kiem tra nhap kieu Long
	public long nhap_kt_Long(Scanner sc) {
		long l;
		do {
			if (sc.hasNextLong()) {
				l = sc.nextLong();
				sc.nextLine();
				break;
			} else {
				sc.nextLine();
				System.out.print("Chi duoc chua so! Nhap lai: ");
			}
		} while (true);
		return l;
	}

	// Kiem tra nhap Ngay gio
	public String nhap_kt_NgayGio(Scanner sc) {
		String st;
		do {
			st = sc.nextLine();
			if (checkDateTime(st)) {
				break;
			} else {
				System.out.print("Nhap sai format, nhap lai: ");
			}
		} while (true);
		return st;
	}

	// Kiem tra NgayGio
	public boolean checkDateTime(String st) {
		return Pattern.compile("\\d\\d\\d\\d-\\d\\d-\\d\\d \\d\\d:\\d\\d:\\d\\d").matcher(st).matches();
	}

	// Binh: ghi thong tin tra phong
	public void traPhong(String idDangKy) {
		TraPhong traphong = new TraPhong();
		traphong.setIdDangKy(idDangKy);

		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String strDate = dateFormat.format(date);

		traphong.setNgayGioTra(strDate);
		arrayListTraPhong.add(traphong);
	}

	public void print_controller_level1() {
		System.out.println("Chon hanh dong: ");
		System.out.println("0. Thoat");
		System.out.println("1. Danh sach Khach Hang");
		System.out.println("2. Them Khach Hang");
		System.out.println("3. Chon Khach Hang");

		Scanner sc = new Scanner(System.in);
		int i = nhap_kt_Int(sc);
		switch (i) {
		case 0:
			break;
		case 1:
			xemDanhSachKhachHang();
			break;
		case 2:
			themKhachHang();
			break;
		case 3:
			chonKhachHang();
			break;
		default:
			System.out.println("Sai!");
			break;

		}
	}

	public void print_controller_level2() {
		System.out.println("Chon hanh dong: ");
		System.out.println("0. Quay lai");
		System.out.println("1. Danh sach phong");
		System.out.println("2. Dang ky");
		System.out.println("3. Xem dang ky");
		System.out.println("4. Huy dang ky");
		System.out.println("5. Goi dich vu");
		System.out.println("6. Thanh Toan dich vu");
		System.out.println("7. Thanh toan dang ky phong");

		Scanner sc = new Scanner(System.in);
		int i = nhap_kt_Int(sc);
		switch (i) {
		case 0:
			print_controller_level1();
			break;
		case 1:
			inDanhSachPhong();
			break;
		case 2:
			nhapDangKy();
			break;
		case 3:
			xemDangKy();
			break;
		case 4:
			huyDangKy();
			break;
		case 5:
			goiDichVu();
			break;
		case 6:
			yeuCauThanhToan(arrayListSuDungDichVu);
			break;
		case 7:
			yeuCauThanhToan();
			break;
		default:
			System.out.println("Sai!");
			break;

		}
	}

	public static void main(String[] a) {
		Controller controller = new Controller();
		Scanner sc = new Scanner(System.in);
		controller.print_controller_level1();
		int i = controller.nhap_kt_Int(sc);
		switch (i) {
		case 1:
			controller.xemDanhSachKhachHang();
			break;
		case 2:
			controller.themKhachHang();
			break;
		case 3:
			controller.chonKhachHang();
		default:
			System.out.println("Sai!");
			break;

		}

	}

}

