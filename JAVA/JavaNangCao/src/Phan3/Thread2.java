package Phan3;

public class Thread2 extends Thread {
	ShareData shareData;

	public Thread2(ShareData shareData) {
		this.shareData = shareData;
	}

	/**
	 * Tao luông 2 để lây lân lượt giá trị trong addressList
	 */
	@Override
	public void run() {
		synchronized (shareData) {
			/* Kiểm tra điều kiện của biến check để chạy luồng*/
			
			
			
			
			for (int i = 0; i < shareData.addressList.size(); i++) {
				while (ShareData.check % 4 != 1) {
					try {
						shareData.wait(); //cho luồng vào trạng thái đợi
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				
				ShareData.check++;

				System.out.println("Address: " + shareData.addressList.get(i));
				
				shareData.notifyAll(); // gọi luồng đang wait
				
				

				

			}

		}
//		System.out.println("T2 dung");

	}

}
