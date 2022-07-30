package Phan5;

/**
 * sử dụng exception với thread trong Java
 *
 */
public class Cau6 {
	public static void main(String[] args) {
		MyThread m = new MyThread();
		try {
			m.start();
			m.start();
		} catch (IllegalThreadStateException e) {
			System.out.println(e);
		}
	}
}

class MyThread extends Thread {
	@Override
	public void run() {
		System.out.println("Throwing in" + " MyThread");
	}
}
