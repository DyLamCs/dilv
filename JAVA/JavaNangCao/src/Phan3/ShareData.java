package Phan3;

import java.util.Arrays;
import java.util.List;

/**
 * Tạo ra 2 List để chứa thôn tin Tên và Địa Chỉ
 *
 */
public class ShareData {
	
	List<String> userList = Arrays.asList("Nguyen Ngoc Lan", "Duong Tien Nam", "Ngo Anh Quan", "Pham Van Duc", "Tran Thi Ha");
	List<String> addressList = Arrays.asList("Hải Phòng", "Hà Nội", "Thái Nguyên", "Hà Tĩnh", "Quảng Ninh");
	List<String> dayOfBirthList = Arrays.asList("1998", "1999", "2000", "1997", "2002");
	List<String> salaryList = Arrays.asList("2500$", "3000$", "3500$", "4000$", "5000$");
	
	//Tạo biến check để kiểm tra luồng nào chạy đầu tiên
	static int check = 0;
	
	public ShareData(){
		
	}

}
