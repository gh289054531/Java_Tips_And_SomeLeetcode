package ThreadPool;

public class MyThread extends Thread {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "����ִ�С�����");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
