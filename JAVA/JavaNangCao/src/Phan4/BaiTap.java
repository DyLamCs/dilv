package Phan4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BaiTap {

	Scanner sc = new Scanner(System.in);

	/**
	 * Lấy ngày sửa đổi cuối cùng của một file trong Java
	 */
	public void getLastModifiedTime() {
		String fileName = "C:\\mydata";
		File file = new File(fileName);

		SimpleDateFormat sdf = new SimpleDateFormat();
		System.out.println("Thoi gian sua doi cuoi cung: " + sdf.format(file.lastModified()));
	}

	/**
	 * Cách tạo một file trong một thư mục cụ thể trong Java
	 */
	public void createFile() {
		boolean isCreat = false;

		System.out.print("Nhap ten file can tao: ");
		String fileName = sc.nextLine();

		File file = new File("C:/mydata/phan4/" + fileName);

		try {
			isCreat = file.createNewFile(); // Tao mot file moi
			if (isCreat) {
				System.out.println("Da tao file thanh cong!");
			} else
				System.out.println("tao file that bai!");
		} catch (IOException e) {
			System.out.println(e);
		}

	}

	/**
	 * Cách kiểm tra một file có tồn tại hay không trong Java?
	 */
	public void fileCheck() {
		// Nhap ten file can check
		System.out.print("Nhap ten file can check: ");
		String fileName = sc.nextLine();
		// tao mot file co duong da
		File file = new File("C:/mydata/phan4/" + fileName);

		if (file.exists()) { // Kiem tra ten file da nhap co ton tai?
			System.out.println("File " + file + " co ton tai");
		} else
			System.out.println("File " + file + " khong co tai");
	}

	/**
	 * Đổi tên một file trong Java
	 */
	public void renameFile() {
		// Nhap ten file can doi
		System.out.println("Nhap ten file can sua: ");
		String fileName = sc.nextLine();
		File oldfile = new File("C:/mydata/phan4/" + fileName);

		if (oldfile.exists()) { // kiem tra file co ton tai hay khong?
			// Nhap ten moi
			System.out.println("Nhap ten moi: ");
			String fileName1 = sc.nextLine();
			File newfile = new File("C:/mydata/phan4/" + fileName1);

			if (oldfile.renameTo(newfile)) { // doi ten file
				System.out.println("Doi ten thanh cong!");
			}
		} else {
			System.out.println("file khong ton tai");
		}

	}

	/**
	 * Lấy kích cỡ một file (giá trị byte) trong Java
	 */
	public void getFileSize() {
		// Nhap vao ten file can xem kich thuoc
		System.out.print("Nhap vao ten file can xem kich thuoc: ");
		String fileName = sc.nextLine();
		File file = new File("C:/mydata/phan4/" + fileName);

		if (!file.exists() || !file.isFile()) { // kiem tra file co ton tai || la dang file
			System.out.println("File khong ton tai");
		} else {

			System.out.println(file.length() + " bytes");
		}

	}

	/**
	 * Thay đổi thời gian sửa đổi cuối cùng của một file trong Java
	 */
	public void changeModifiedFile() {
		// Nhập file cần chỉnh sửa
		System.out.print("Nhập tên file cần cập nhật: ");
		String fileName = sc.nextLine();
		File file = new File("C:/mydata/phan4/" + fileName);

		if (file.exists()) {
			Date date = new Date(file.lastModified()); // lấy thời gian cuối cùng cập nhật file định dạng theo kiểu date
			System.out.println("Thời gian cập nhật file: " + date); // in thời gian cập nhật file cuối cùng

			file.setLastModified(System.currentTimeMillis()); // thay đổi (update) thời gian chỉnh sửa thành ngày hiện
																// tại
			System.out.println(new Date(file.lastModified())); // in thời gian chỉnh sửa file vừa thay đổi

		} else {
			System.out.println("File không tồn tại");
		}

	}

	/**
	 * Cách phụ thêm một String trong file đang tồn tại trong Java
	 */
	public void addStringToFile() {
		System.out.print("Nhap ten file can them String: ");
		String fileName = sc.nextLine();
		File file = new File("C:/mydata/phan4/" + fileName);
		if (file.exists()) {
			try {
				BufferedWriter bfw = new BufferedWriter(new FileWriter(file, true));
				System.out.print("Nhap chuoi can them vao file: ");
				String text = sc.nextLine();
				bfw.write(text);
				bfw.close();
				System.out.println("done!");
			} catch (IOException e) {
				System.out.println(e);
			}
		}
	}

	/**
	 * Sao chép một file vào trong file khác trong Java
	 */
	public void copyFile() {
		File f = new File("C:/mydata/phan4");
		File fCopy = new File("C:/mydata/phan4Copy");

		try {
			Files.copy(f.toPath(), fCopy.toPath(), StandardCopyOption.REPLACE_EXISTING);

		} catch (IOException e) {
			System.out.println(e);
		}
	}

	/**
	 * Phương thức sao chép file
	 * 
	 */
	public void copyContentFile() {
		InputStream inStream = null;						// Đọc dữ liệu
		OutputStream outStream = null;						// Ghi du lieu vao ile
		/* Nhập thông tin file */
		System.out.println("Nhập tên file muốn sao chép");
		String nameFileOut = sc.nextLine();
		File fileOut = new File("C:/mydata/phan4/" + nameFileOut);
		
		System.out.println("Nhập tên file muốn chép vào");
		String nameFileIn = sc.nextLine();
		File fileIn = new File("C:/mydata/phan4/" + nameFileIn);
		
		try {
			/* Kiểm tra file được sao chép có tồn tại */
			if (fileOut.exists()) {
				System.out.println("co ton tai");
				/* Kiểm tra file được sao chép tới có tồn tại */
				if (!fileIn.exists()) {
					fileIn.createNewFile(); // Tạo file mới
				}
				inStream = new FileInputStream(fileOut);
				outStream = new FileOutputStream(fileIn);
				byte[] buffer = new byte[1024];
				int length;
				/* Ghi vào file mới */
				while ((length = inStream.read(buffer)) > 0) {
					outStream.write(buffer, 0, length);
				}
				inStream.close();
				outStream.close();
				System.out.println("Chép nội dung file từ " + nameFileOut + " đến " + nameFileIn + " thành công");
			} else {
				System.out.println("File sao chép không tồn tại");
			}
		} catch (IOException ie) {
			System.err.println("Có lỗi trong quá trình xử lý");
		}

	}

	/**
	 * Xóa một file trong Java
	 */
	public void deleteFile() {
		System.out.print("Nhap ten file can xoa: ");
		String fileName = sc.nextLine();
		File file = new File("C:/mydata/phan4/" + fileName);

		if (file.exists()) {
			file.delete();
			System.out.println("da xoa thanh cong");
		} else {
			System.out.println("file khong ton tai");
		}
	}

	/**
	 * GHI một file trong Java
	 */
	public void writeFile() {
		System.out.print("Nhap ten file can ghi them thong tin: ");
		String fileName = sc.nextLine();
		File file = new File("C:/mydata/phan4/" + fileName);
		if (file.exists()) {
			try {
				/*BufferedWriter trong java được sử dụng để cung cấp bộ đệm cho các các thể hiện của lớp Writer
				 *FileWriter trong java được sử dụng để ghi các dữ liệu theo định dạng ký tự vào một file.*/
				BufferedWriter bfw = new BufferedWriter(new FileWriter(file));
				System.out.print("Nhap thong tin can them vao file: ");
				String text = sc.nextLine();
				bfw.write(text);
				bfw.close();
				System.out.println("done!");
			} catch (IOException e) {
				System.out.println("Loi trong qua trinh xu ly");
			}
		}
	}

	public void writeFileWithPrintWrite() {
		/* Nhập tên file muốn ghi */
		System.out.println("Nhập tên file muốn ghi");
		String fileName = sc.nextLine();
		File file = new File("C:/mydata/phan4/" + fileName);
		try {
			/* Kiểm tra file có tồn tại */
			if (!file.exists()) {
				file.createNewFile(); // Tạo file mới
			}
			System.out.println("Nhập nội dung file");
			String content = sc.nextLine();
			FileWriter fileW = new FileWriter(file); // FileWriter trong java được sử dụng để ghi các dữ liệu 
			fileW.write(content); // Ghi nội dung vào file
			fileW.close();
		} catch (IOException e) {
			System.out.println("Loi trong qua trinh xu ly");
		}
		System.out.println("Ghi file thành công");

	}

	/**
	 * GHI một file trong Java
	 */
	public void readFile() {
		System.out.print("Nhap ten file can doc: ");
		String fileName = sc.nextLine();

		try {
			File file = new File("C:/mydata/phan4/" + fileName);
			if (file.exists()) {
				/*FileReader trong java được sử dụng để đọc dữ liệu từ file. 
				 *Nó trả về dữ liệu theo định dạng byte như lớp FileInputStream.*/
				FileReader fr = new FileReader(file);
				int i;
				try {
					while ((i = fr.read()) != -1) {
						System.out.print((char) i);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		} catch (FileNotFoundException e) {
			System.out.println("Loi trong qua trinh xu ly");
		}

	}

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		BaiTap run = new BaiTap();
		int dk;

		do {
			System.out.println("CHỌN HÀNH ĐỘNG: ");
			System.out.println("\t0. Thoat.");
			System.out.println("\t1. Lấy ngày sửa đổi cuối cùng của một file trong Java.");
			System.out.println("\t2. Tạo một file trong một thư mục cụ thể trong Java.");
			System.out.println("\t3. Kiểm tra một file có tồn tại hay không trong Java.");
			System.out.println("\t4. Đổi tên một file trong Java.");
			System.out.println("\t5. Lấy kích cỡ một file (giá trị byte) trong Java.");
			System.out.println("\t6. Thay đổi thời gian sửa đổi cuối cùng của một file trong Java.");
			System.out.println("\t7. Phụ thêm một String trong file đang tồn tại trong Java.");
			System.out.println("\t8. COPPY foder trong Java.");
			System.out.println("\t9. COPPY noi dung một file vào trong file khác trong Java.");
			System.out.println("\t10. XÓA một file trong Java.");
			System.out.println("\t11. GHI một file trong Java.");
			System.out.println("\t12. GHI một file trong Java (lớp PrintWriter).");
			System.out.println("\t13. ĐỌC một file trong Java.");

			dk = scanner.nextInt();

			switch (dk) {
			case 0:
				break;
			case 1:
				run.getLastModifiedTime();
				break;
			case 2:
				run.createFile();
				break;
			case 3:
				run.fileCheck();
				break;
			case 4:
				run.renameFile();
				break;
			case 5:
				run.getFileSize();
				break;
			case 6:
				run.changeModifiedFile();
				break;
			case 7:
				run.addStringToFile();
				break;
			case 8:
				run.copyFile();
				break;
			case 9:
				run.copyContentFile();
				break;	
			case 10:
				run.deleteFile();
				break;
			case 11:
				run.writeFile();
				break;
			case 12:
				run.writeFileWithPrintWrite();
				break;
			case 13:
				run.readFile();
				break;
			default:
				System.out.println("Sai!");
				break;
			}
		} while (dk != 0);

		scanner.close();

	}
}
