package Controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

import bai10.DangKy;
import bai10.DichVu;
import bai10.HuyDangKy;
import bai10.KhachHang;
import bai10.NhanPhong;
import bai10.Phong;
import bai10.SuDungDichVu;
import bai10.ThanhToan;
import bai10.TraPhong;

public class Controller {
	final String file_kh = "C://mydata/khachhang.txt";
	final String file_dk = "C://mydata/dangky.txt";
	final String file_tt = "C://mydata/thanhtoan.txt";
	final String file_sddv = "C://mydata/sudungdichvu.txt";
	final String file_p = "C://mydata/phong.txt";

	int viTriKhachHang = 0;

	ArrayList<Integer> danhSachDichVu = new ArrayList<Integer>();
	ArrayList<DichVu> arrayListDichVu = new ArrayList<DichVu>();
	ArrayList<KhachHang> arrayListKhachHang = new ArrayList<KhachHang>();
	ArrayList<SuDungDichVu> arrayListSuDungDichVu = new ArrayList<SuDungDichVu>();
	ArrayList<TraPhong> arrayListTraPhong = new ArrayList<TraPhong>();
	ArrayList<DangKy> arrayListDangKy = new ArrayList<DangKy>();
	ArrayList<HuyDangKy> arrayListHuyDangKy = new ArrayList<HuyDangKy>();
	ArrayList<Phong> arrayListPhong = new ArrayList<Phong>();
	ArrayList<NhanPhong> arrayListNhanPhong = new ArrayList<NhanPhong>();
	ArrayList<ThanhToan> arrayListThanhToan = new ArrayList<ThanhToan>();

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

	// Khoi tao du lieu Phong
	public void addPhongDefault() {
		arrayListPhong.add(new Phong("101", "Thuong", false, 300000));
		arrayListPhong.add(new Phong("102", "Thuong", false, 300000));
		arrayListPhong.add(new Phong("103", "Thuong", false, 300000));
		arrayListPhong.add(new Phong("104", "Thuong", false, 300000));
		arrayListPhong.add(new Phong("105", "Thuong", false, 300000));
		arrayListPhong.add(new Phong("201", "VIP   ", false, 500000));
		arrayListPhong.add(new Phong("202", "VIP   ", false, 500000));
		arrayListPhong.add(new Phong("203", "VIP   ", false, 500000));
		arrayListPhong.add(new Phong("204", "VIP   ", false, 500000));
		arrayListPhong.add(new Phong("205", "VIP   ", false, 500000));

	}

	// Ghi phong
	public void ghiPhong() {
		try (FileOutputStream fos = new FileOutputStream(file_p); DataOutputStream dos = new DataOutputStream(fos);) {
			for (Phong phong : arrayListPhong) {
				dos.writeUTF(phong.getIdPhong());
				dos.writeUTF(phong.getLoaiPhong());
				dos.writeBoolean(phong.isTrangThaiPhong());
				dos.writeLong(phong.getGiaPhong());
			}
			dos.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Doc file khach hang
	public void docKhachHang() {
		try (FileInputStream fis = new FileInputStream(file_kh); DataInputStream dis = new DataInputStream(fis);) {
			while (dis.available() > 0) {
				KhachHang kh = new KhachHang();

				kh.setIdKhachHang(dis.readUTF());
				kh.setHoTen(dis.readUTF());
				kh.setGioiTinh(dis.readUTF());
				kh.setNgaySinh(dis.readUTF());
				kh.setDiaChi(dis.readUTF());
				kh.setSoDienThoai(dis.readUTF());
				kh.setCccd(dis.readUTF());
				kh.setEmailKhachHang(dis.readUTF());
				kh.setQuocTichKhachHang(dis.readUTF());
				arrayListKhachHang.add(kh);
			}
			dis.close();
			fis.close();
		}

		catch (IOException ie) {
			System.out.println(ie);
		}
	}

	// Doc file dang ky
	public void docDangKy() {
		try {
			FileInputStream fis = new FileInputStream(file_dk);
			DataInputStream dis = new DataInputStream(fis);

			while (dis.available() > 0) {
				DangKy dangky = new DangKy();

				dangky.setIdDangKy(dis.readUTF());
				dangky.setIdKhachHang(dis.readUTF());
				dangky.setIdPhong(dis.readUTF());
				dangky.setTienCoc(dis.readLong());
				dangky.setNgayDangKy(dis.readUTF());
				dangky.setNgayGioDen(dis.readUTF());
				dangky.setNgayGioDi(dis.readUTF());
				dangky.setSoLuongNguoiLon(dis.readInt());
				dangky.setSoLuongTreEm(dis.readInt());
				dangky.setTrangThai(dis.readBoolean());

				System.out.println(dangky.toString());
				arrayListDangKy.add(dangky);
			}

			fis.close();
			dis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Doc Su dung dich vu
	public void docSuDungDichVu() {
		try {
			FileInputStream fis = new FileInputStream(file_sddv);
			DataInputStream dis = new DataInputStream(fis);

			while (dis.available() > 0) {
				SuDungDichVu sudungdichvu = new SuDungDichVu();

				sudungdichvu.setIdKhachHang(dis.readUTF());
				sudungdichvu.setIdDichVu(dis.readInt());
				sudungdichvu.setNgaySuDung(dis.readUTF());
				sudungdichvu.setDonGiaDichVu(dis.readLong());

				arrayListSuDungDichVu.add(sudungdichvu);
			}

			fis.close();
			dis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Doc Thanh Toan
	public void docthanhToan() {
		try {
			FileInputStream fis = new FileInputStream(file_tt);
			DataInputStream data = new DataInputStream(fis);

			while (data.available() > 0) {

				long idSuDungDichVu = data.readLong();
				String idDangKy = data.readUTF();
				String ngayGioThanhToan = data.readUTF();
				long soTien = data.readLong();
				ThanhToan thanhToan = new ThanhToan(idSuDungDichVu, idDangKy, ngayGioThanhToan, soTien);
				arrayListThanhToan.add(thanhToan);
			}

			data.close();
			fis.close();
		} catch (Exception ie) {
			System.out.println(ie);
		}

	}

	// Doc phong
	public void docPhong() {
		try {
			FileInputStream fis = new FileInputStream(file_p);
			DataInputStream dis = new DataInputStream(fis);

			while (dis.available() > 0) {
				Phong phong = new Phong();

				phong.setIdPhong(dis.readUTF());
				phong.setLoaiPhong(dis.readUTF());
				phong.setTrangThaiPhong(dis.readBoolean());
				phong.setGiaPhong(dis.readLong());

				arrayListPhong.add(phong);
			}

			fis.close();
			dis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		try (FileOutputStream fos = new FileOutputStream(file_kh, true);
				DataOutputStream dos = new DataOutputStream(fos);
				Scanner sc = new Scanner(System.in);) {
//			while(true) {
			System.out.println("Nhap thong tin con nguoi: ");

			System.out.print("nhap ma KH: ");
			String idKH = sc.nextLine();
			kh.setIdKhachHang(idKH);

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

			System.out.println("Email KH: ");
			String email = sc.nextLine();
			kh.setEmailKhachHang(email);

			System.out.println("Quoc tich KH: ");
			String quoctich = sc.nextLine();
			kh.setQuocTichKhachHang(quoctich);

			dos.writeUTF(idKH);
			dos.writeUTF(hoten);
			dos.writeUTF(gioitinh);
			dos.writeUTF(ngaysinh);
			dos.writeUTF(diachi);
			dos.writeUTF(sdt);
			dos.writeUTF(cccd);
			dos.writeUTF(email);
			dos.writeUTF(quoctich);

			arrayListKhachHang.add(kh);

			dos.close();
			fos.close();
			print_controller_level1();
//			}			
		}

		catch (IOException ie) {
			System.out.println(ie);
		}
	}

	// Chon khach hang
	public void chonKhachHang() {
		boolean check = false;

		try (Scanner sc = new Scanner(System.in)) {
			do {
				int i = 0;
				System.out.print("Nhap ma Khach Hang: ");
				String makh = sc.nextLine();
				for (KhachHang khachHang : arrayListKhachHang) {
					if (khachHang.getIdKhachHang().equals(makh)) {
						System.out.println("Da xac nhan");
						viTriKhachHang = i;
						print_controller_level2();
						check = true;
						break;
					}
					i++;
				}
				if (!check)
					System.out.println("Khong tim thay ma Khach Hang nay!");
			} while (!check);

		}

	}

	// In danh sach phong
	public void inDanhSachPhong() {
		for (Phong phong : arrayListPhong) {
			System.out.println(phong.toString());
		}
	}

	// Nhap Dang Ky
	public void nhapDangKy() {
		DangKy dk = new DangKy();

		try (FileOutputStream fos = new FileOutputStream(file_dk, true);
				DataOutputStream dos = new DataOutputStream(fos);
				Scanner sc = new Scanner(System.in);) {
//			while (true) {

			System.out.println("Ma dang ky: ");
			String madk = sc.nextLine();
			dk.setIdDangKy(madk);

			System.out.println("Ma Phong: ");
			String maphong = sc.nextLine();
			dk.setIdPhong(maphong);

			System.out.println("tien dat coc: ");
			long tiencoc = nhap_kt_Long(sc);
			dk.setTienCoc(tiencoc);

			System.out.println("Ngay dang ky: ");
			String ngaydangky = sc.nextLine();
			dk.setNgayDangKy(ngaydangky);

			System.out.println("Ngay den yyyy/mm/dd hh:mm ");
			String ngaygioden = nhap_kt_NgayGio(sc);
			dk.setNgayGioDen(ngaygioden);

			System.out.println("Ngay di yyyy/mm/dd hh:mm ");
			String ngaygiodi = nhap_kt_NgayGio(sc);
			dk.setNgayGioDi(ngaygiodi);

			System.out.println("So luong nguoi lon: ");
			int slnl = nhap_kt_Int(sc);
			dk.setSoLuongNguoiLon(slnl);

			System.out.println("So luong tre em: ");
			int slte = nhap_kt_Int(sc);
			dk.setSoLuongTreEm(slte);

			dos.writeUTF(madk);
			dos.writeUTF(arrayListKhachHang.get(viTriKhachHang).getIdKhachHang());
			dos.writeUTF(maphong);
			dos.writeLong(tiencoc);
			dos.writeUTF(ngaydangky);
			dos.writeUTF(ngaygioden);
			dos.writeUTF(ngaygiodi);
			dos.writeInt(slnl);
			dos.writeInt(slte);
			dos.writeBoolean(dk.isTrangThai());

			dos.close();
			fos.close();

//			}
		} catch (IOException ie) {
			System.out.println(ie);
		}
	}

	// Ghi lai dang ky
	public void ghiLaiDangKy() {
		try (FileOutputStream fos = new FileOutputStream(file_dk);
				DataOutputStream dos = new DataOutputStream(fos);
				Scanner sc = new Scanner(System.in);) {
			for (DangKy dk : arrayListDangKy) {
				dos.writeUTF(dk.getIdDangKy());
				dos.writeUTF(dk.getIdKhachHang());
				dos.writeUTF(dk.getIdPhong());
				dos.writeLong(dk.getTienCoc());
				dos.writeUTF(dk.getNgayDangKy());
				dos.writeUTF(dk.getNgayGioDen());
				dos.writeUTF(dk.getNgayGioDi());
				dos.writeInt(dk.getSoLuongNguoiLon());
				dos.writeInt(dk.getSoLuongTreEm());
				dos.writeBoolean(dk.isTrangThai());
			}
			dos.close();
			fos.close();
		} catch (IOException ie) {
			System.out.println(ie);
		}
	}

	// Xem dang ky
	public void xemDangKy() {
		for (DangKy dangKy : arrayListDangKy) {
			if (dangKy.getIdKhachHang().equals(arrayListKhachHang.get(viTriKhachHang).getIdKhachHang())) {
				System.out.println(dangKy.toString());
			}
		}
	}

	// Huy dang ky
	public void huyDangKy() {
		for (DangKy dangky : arrayListDangKy) {
			if (dangky.getIdKhachHang().equals(arrayListKhachHang.get(viTriKhachHang).getIdKhachHang())
					&& dangky.isTrangThai()) {
				traPhong(dangky.getIdDangKy());

				Date date = Calendar.getInstance().getTime();
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm");
				String strDate = dateFormat.format(date);

				HuyDangKy huyDangKy = new HuyDangKy(dangky.getIdDangKy(), strDate);
				arrayListHuyDangKy.add(huyDangKy);
				dangky.setTrangThai(false);
				System.out.println(huyDangKy.toString());
				break;
			}
		}
		ghiLaiDangKy();
	}

	// IN ra bang dich vu
	public void xemDichVu() {
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
			DateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd hh:mm");
			String strDate = dateFormat.format(date);
			arrayListSuDungDichVu.add(new SuDungDichVu(arrayListKhachHang.get(viTriKhachHang).getIdKhachHang(),
					idDichVu, strDate, dv.getGiaDichVu()));
		}
		for (SuDungDichVu sddv : arrayListSuDungDichVu) {
			System.out.println(sddv.toString());
		}
		ghiSuDungDichVu();
	}

	// Nhap file Su dung dich vu
	public void ghiSuDungDichVu() {
		try {
			FileOutputStream fos = new FileOutputStream(file_sddv);
			DataOutputStream dos = new DataOutputStream(fos);
			for (SuDungDichVu sddv : arrayListSuDungDichVu) {
				dos.writeUTF(sddv.getIdKhachHang());
				dos.writeInt(sddv.getIdDichVu());
				dos.writeUTF(sddv.getNgaySuDung());
				dos.writeLong(sddv.getDonGiaDichVu());
			}

			dos.close();
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Ghi thanh toan
	public void ghiThanhToan() {

		try {
			FileOutputStream fos = new FileOutputStream(file_tt);
			DataOutputStream dos = new DataOutputStream(fos);

			for (ThanhToan thanhToan : arrayListThanhToan) {
				dos.writeLong(thanhToan.getIdSuDungDichVu());
				dos.writeUTF(thanhToan.getIdDangKy());
				dos.writeUTF(thanhToan.getNgayGioThanhToan());
				dos.writeLong(thanhToan.getSoTien());

			}
			fos.close();
			dos.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Thuc hien yeu cau thanh toan dich vu cua kh
	public void yeuCauThanhToanDV() {
		boolean check = false;
		long tongTien = 0;
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd hh:mm");
		String strDate = dateFormat.format(date);

		for (SuDungDichVu sddv : arrayListSuDungDichVu) {
			if (sddv.getIdKhachHang().equals(arrayListKhachHang.get(viTriKhachHang).getIdKhachHang())) {
				check = true;
				ThanhToan thanhToan = new ThanhToan();
				thanhToan.setNgayGioThanhToan(strDate);
				thanhToan.setIdSuDungDichVu(sddv.getIdSuDungDichVu());
				thanhToan.setSoTien(sddv.getDonGiaDichVu());
				System.out.println(thanhToan.toString());
				tongTien += sddv.getDonGiaDichVu();
			}
		}
		if (!check) {
			System.out.println("Khong co dich vu!");
		} else
			System.out.println("Tong tien: " + tongTien);
	}

	// Thuc hien yeu cau thanh toan phong cua kh
	public void yeuCauThanhToan() {
		for (DangKy dangky : arrayListDangKy) {
			if (dangky.getIdKhachHang().equals(arrayListKhachHang.get(viTriKhachHang).getIdKhachHang())
					&& dangky.isTrangThai()) {
				traPhong(dangky.getIdDangKy());

				Date date = Calendar.getInstance().getTime();
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm");
				String strDate = dateFormat.format(date);

				ThanhToan thanhToan = new ThanhToan();
				thanhToan.setNgayGioThanhToan(strDate);
				thanhToan.setIdDangKy(dangky.getIdDangKy());
				for (Phong phong : arrayListPhong) {
					if (dangky.getIdPhong().equals(phong.getIdPhong())) {
						try {
							Date ngay_den = dateFormat.parse(dangky.getNgayGioDen());
							Date ngay_di = dateFormat.parse(dangky.getNgayGioDi());
							long so_ngay = (ngay_di.getTime() - ngay_den.getTime()) / (24 * 3600 * 1000);
							thanhToan.setSoTien(phong.getGiaPhong() * so_ngay - dangky.getTienCoc());
							dangky.setTrangThai(false);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						break;
					}
				}
				arrayListThanhToan.add(thanhToan);
				System.out.println(thanhToan.toString());
				break;
			}
		}
		ghiThanhToan();
	}

	// Kiem tra co chua ky tu so hay khong
	public boolean checkNum(String st) {
		return Pattern.compile("\\d+").matcher(st).find(); //
	}

	// Kiem tra co chua ky tu khac so hay khong
	public boolean checkChar(String st) {
		return Pattern.compile("\\D+").matcher(st).find(); //
	}

	// Kiem tra nhap Integer
	public int nhap_kt_Int(Scanner sc) {
		int i;
		String lString;
		do {
			if (sc.hasNextLine()) {
				lString = sc.nextLine();
				if (!checkChar(lString))
					break;
				else
					System.out.println("Chi duoc nhap so! Nhap Lai: ");
			}
		} while (true);
		i = Integer.parseInt(lString);
		return i;
	}

	// Kiem tra nhap kieu Long
	public long nhap_kt_Long(Scanner sc) {
		long l;
		String lString;
		do {
			lString = sc.nextLine();
			if (!checkChar(lString))
				break;
			else
				System.out.println("Chi duoc nhap so! Nhap Lai: ");
		} while (true);
		l = Long.parseLong(lString);
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
		return Pattern.compile("\\d\\d\\d\\d/\\d\\d/\\d\\d \\d\\d:\\d\\d").matcher(st).matches();
	}

	// nhan phong
	public void nhanPhong() {
		for (DangKy dangky : arrayListDangKy) {
			if (dangky.getIdKhachHang().equals(arrayListKhachHang.get(viTriKhachHang).getIdKhachHang())
					&& dangky.isTrangThai()) {

				Date date = Calendar.getInstance().getTime();
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm");
				String strDate = dateFormat.format(date);

				NhanPhong nhanPhong = new NhanPhong(strDate, dangky.getIdDangKy(), dangky.getIdPhong());
				arrayListNhanPhong.add(nhanPhong);
				for (Phong phong : arrayListPhong) {
					if (dangky.getIdPhong().equals(phong.getIdPhong())) {
						phong.setTrangThaiPhong(true);
						break;
					}
				}
				System.out.println(nhanPhong.toString());
				break;
			}
		}
		ghiPhong();
	}

	// Binh: ghi thong tin tra phong
	public void traPhong(String idDangKy) {
		TraPhong traphong = new TraPhong();
		traphong.setIdDangKy(idDangKy);

		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd hh:mm");
		String strDate = dateFormat.format(date);

		traphong.setNgayGioTra(strDate);
		arrayListTraPhong.add(traphong);
	}

	// Xem danh sach phong
	public void xemPhong() {
		for (Phong phong : arrayListPhong) {
			System.out.println(phong.toString());
		}
	}

	public void print_controller_level1() {
		System.out.println("Chon hanh dong: ");
		System.out.println("\t0. Thoat");
		System.out.println("\t1. Danh sach Khach Hang");
		System.out.println("\t2. Them Khach Hang");
		System.out.println("\t3. Chon Khach Hang");
		System.out.println("\t4. Danh sach phong");

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
			xemDanhSachKhachHang();
			chonKhachHang();
			break;
		case 4:
			xemPhong();
			break;
		default:
			System.out.println("Sai!");
			break;

		}
		if (i != 0) {
			print_controller_level1();
		}

	}

	public void print_controller_level2() {
		System.out.println("Chon hanh dong: ");
		System.out.println("\t0. Quay lai");
		System.out.println("\t1. Dang ky");
		System.out.println("\t2. Xem dang ky");
		System.out.println("\t3. Huy dang ky");
		System.out.println("\t4. Nhan phong");
		System.out.println("\t5. Goi dich vu");
		System.out.println("\t6. Thanh Toan dich vu");
		System.out.println("\t7. Thanh toan dang ky phong");

		int i = -1;

		Scanner sc = new Scanner(System.in);
		i = nhap_kt_Int(sc);
		switch (i) {
		case 0:
			print_controller_level1();
			break;
		case 1:
			nhapDangKy();
			print_controller_level2();
			break;
		case 2:
			xemDangKy();
			print_controller_level2();
			break;
		case 3:
			huyDangKy();
			print_controller_level2();
			break;
		case 4:
			nhanPhong();
			print_controller_level2();
			break;
		case 5:
			xemDichVu();
			goiDichVu();
			print_controller_level2();
			break;
		case 6:
			yeuCauThanhToanDV();
			print_controller_level1();
			break;
		case 7:
			yeuCauThanhToan();
			print_controller_level1();
			break;
		default:
			System.out.println("Sai!");
			break;

		}

	}

	public static void main(String[] a) {
		Controller controller = new Controller();
		controller.addDichVuDefault();
//		controller.addPhongDefault();
//		controller.ghiPhong();
		controller.docPhong();
		controller.docKhachHang();
		controller.docDangKy();
		controller.docSuDungDichVu();
		controller.docthanhToan();

		controller.print_controller_level1();

	}

}
