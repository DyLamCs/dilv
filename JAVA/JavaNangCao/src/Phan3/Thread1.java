package Phan3;

/**
 * Luồng chạy thứ 1
 *
 */
public class Thread1 extends Thread {
	ShareData shareData;

	/**
	 * Phương thức khởi tạo truyền tham số chứa dữ liệu của luồng
	 */
	public Thread1(ShareData shareData) {
		this.shareData = shareData;
	}

	/**
	 * Tao luông 1 để lây lân lượt giá trị trong userList
	 */
	@Override
	public void run() {
		synchronized (shareData) {
			
			for (int i = 0; i < shareData.userList.size(); i++) {
				while (ShareData.check % 4 != 0) {
					try {
						shareData.wait(); // cho luồng vào trạng thái đợi
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}

				ShareData.check++;

				System.out.println("User: " + shareData.userList.get(i));
				
				shareData.notifyAll(); // đánh thức luồng đang wait
				
				

			}

		}
//		System.out.println("T1 dung");

	}
}
