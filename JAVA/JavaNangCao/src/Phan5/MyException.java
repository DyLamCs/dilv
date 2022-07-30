package Phan5;

/**
 * MyException ke thua Exception được định nghĩa bởi người dùng
 *
 */
public class MyException extends Exception {
	

	/**
	 * Để đánh dấu phiên bản của lớp này
	 */
	private static final long serialVersionUID = 1L;

	public MyException(String error) {
		super(error);
	}

	

}
