package Phan3;

public class Thread3 extends Thread {
	ShareData shareData;

	public Thread3(ShareData shareData) {
		this.shareData = shareData;
	}

	@Override
	public void run() {
		synchronized (shareData) {
			for (int i = 0; i < shareData.addressList.size(); i++) {
				while (ShareData.check % 4 != 2) {
					try {
						shareData.wait(); // cho luồng vào trạng thái đợi
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}

				ShareData.check++;

				System.out.println("Day Of Birth: " + shareData.dayOfBirthList.get(i));

				shareData.notifyAll(); // gọi luồng đang wait

			}

		}

	}
}
