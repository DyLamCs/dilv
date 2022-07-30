package Phan3;

public class Thread4 extends Thread {
	ShareData shareData;

	public Thread4(ShareData shareData) {
		this.shareData = shareData;
	}

	@Override
	public void run() {
		synchronized (shareData) {
			for (int i = 0; i < shareData.salaryList.size(); i++) {
				while (ShareData.check % 4 != 3) {
					try {
						shareData.wait(); // cho luồng vào trạng thái đợi
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}

				ShareData.check++;

				System.out.println("Salary: " + shareData.salaryList.get(i) + "\n");

				shareData.notifyAll(); // gọi luồng đang wait

			}

		}

	}
}
