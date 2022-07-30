package com.example.b13;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.Scanner;

public class Run {
	Scanner sc = new Scanner(System.in);
	ArrayList<Phong> danhSachPhong = new ArrayList<Phong>();

	// Khoi tao du lieu Phong
	public void nhapDanhSachPhong() {
		danhSachPhong.add(new Phong("101", "Thuong", false, 250000));
		danhSachPhong.add(new Phong("102", "Thuong", false, 250000));
		danhSachPhong.add(new Phong("202", " V I P", false, 500000));
		danhSachPhong.add(new Phong("202", " V I P", false, 500000));
		danhSachPhong.add(new Phong("301", "Thuong", true, 250000));
		danhSachPhong.add(new Phong("302", "Thuong", true, 250000));
		danhSachPhong.add(new Phong("401", " V I P", true, 900000));
		
		

	}

	// Them phong
	public void themPhong() {
		System.out.println("Nhập thông tin phòng cần thêm: ");
		do {
			Phong phong = new Phong();
			System.out.print("\t So phong: ");
			String idPhong;
			do {
				idPhong = sc.nextLine();
			} while (ktMaPhong(idPhong));
			phong.setIdPhong(idPhong);
			System.out.print("\t Loai phong: ");
			phong.setLoaiPhong(sc.nextLine());
			System.out.print("\t Trang thai phong: ");
			phong.setTrangThaiPhong(ktNhapBoolean());
			System.out.print("\t Gia phong: ");
			phong.setGiaPhong(sc.nextLong());
			danhSachPhong.add(phong);
			System.out.println("Tiep tuc khong (Y/N)?");
			String s = sc.next();
			sc.nextLine();
			if (s.equals("N") || s.equals("n")) {
				break;
			}
		} while (true);
	}

	// Cap nhat thong tin
	public void capNhatThongTinPhong() {
		String idPhong;
		boolean check = false;

		do {
			System.out.println("Nhap ma phong can sua: ");
			idPhong = sc.nextLine();
			ListIterator<Phong> iter = danhSachPhong.listIterator();
			while (iter.hasNext()) {
				Phong phong = iter.next();
				if (phong.getIdPhong().equals(idPhong)) {
					check = true;
					
					System.out.print("Nhap loai phong: ");
					phong.setLoaiPhong(sc.nextLine());
					iter.set(phong);
					
					System.out.print("Nhap trang thai: ");
					phong.setTrangThaiPhong(ktNhapBoolean());
					iter.set(phong);
					
					System.out.print("Nhap gia: ");
					phong.setGiaPhong(sc.nextLong());
					iter.set(phong);											
					break;
				}
				
			}
			
			if (!check)
				System.out.println("Khong tim thay ma phong nay!");
		} while (!check);	
		
	}



	// Xoa phong
	public void xoaPhong() {
		String idPhong;
		boolean check = false;
		do {
			System.out.print("Nhập mã phòng cần xóa: ");
			idPhong = sc.nextLine();
			ListIterator<Phong> iter = danhSachPhong.listIterator();
			while (iter.hasNext()) {
				Phong phong = iter.next();
				if (phong.getIdPhong().equals(idPhong)) {
					check = true;
					iter.remove();
					System.out.println("Da xoa phong " + idPhong + "!");
					break;
				}
			}
			if (!check)
				System.out.println("Mã phòng " + idPhong + " không tồn tại!");
		} while (!check);

	}

	// In danh sach phong
	public void inDanhSachPhong() {
		System.out.println(">>>---Danh sách tất cả các phòng<<<---");
		for (Phong phong : danhSachPhong) {
			System.out.println(phong.toString());
		}
	}

	// In danh sach phong chua thue
	public void inDanhSachPhongChuaThue() {
		System.out.println(">>>---Danh sách phòng chưa cho thuê<<<---");
		for (Phong phong : danhSachPhong) {
			if (phong.isTrangThaiPhong() == false) {
				System.out.println(phong.toString());
			}
		}
	}

	// Sap xep phong
	public void sapXepPhong() {
		System.out.println(">>>---Danh sách phòng sau khi sắp xếp<<<---");
		danhSachPhong.sort(Comparator.comparing(Phong::getIdPhong));
		inDanhSachPhong();
	}

	// Hanh dong
	public void kichBan() {
		System.out.println("\nChon hanh dong: ");
		System.out.println("\t 0. Thoat");
		System.out.println("\t 1. Them Phong: ");
		System.out.println("\t 2. Cap nhat phong: ");
		System.out.println("\t 3. Xoa phong: ");
		System.out.println("\t 4. In danh sach phong: ");
		System.out.println("\t 5. In danh sach chua cho thue: ");
		System.out.println("\t 6. Sap xep phong: ");

		int i = -1;
		i = ktNhapInt();
		switch (i) {
		case 0:
			break;
		case 1:
			themPhong();
			break;
		case 2:
			capNhatThongTinPhong();
			break;
		case 3:
			xoaPhong();
			break;
		case 4:
			inDanhSachPhong();
			break;
		case 5:
			inDanhSachPhongChuaThue();
			break;
		case 6:
			sapXepPhong();
			break;
		default:
			System.out.println("Nhap Sai!");
			break;
		}
		if (i != 0) {
			kichBan();
		} else {
			sc.close();
		}
	}

	// Kiem tra ma phong
	public boolean ktMaPhong(String idPhong) {
		for (Phong phong : danhSachPhong) {
			if (phong.getIdPhong().equals(idPhong)) {
				System.out.println("Phòng " + idPhong + " đã tồn tại trong danh sách phòng!");
				return true;
			}
		}
		return false;
	}

	// Kiem tra nhap Int
	public int ktNhapInt() {
		int i;
		do {
			if (sc.hasNextInt()) {
				i = sc.nextInt();
				sc.nextLine();
				break;
			} else {
				sc.nextLine();
				System.out.println("Chi nhap so!");
			}
		} while (true);
		return i;
	}

	// Kiem tra nhap Int
	public long ktNhapLong() {
		long i;
		do {
			if (sc.hasNextLong()) {
				i = sc.nextLong();
				sc.nextLine();
				break;
			} else {
				sc.nextLine();
				System.out.println("Chi nhap so!");
			}
		} while (true);
		return i;
	}

	// Kiem tra nhap boolean
	public boolean ktNhapBoolean() {
		boolean b;
		do {
			if (sc.hasNextBoolean()) {
				b = sc.nextBoolean();
				sc.nextLine();
				break;
			} else {
				sc.nextLine();
				System.out.println("Chi nhap \"true\" hoac \"false\": ");
			}

		} while (true);
		return b;
	}



	public static void main(String[] args) {
		Run run = new Run();
		run.nhapDanhSachPhong();
		run.kichBan();

		

	}

}
