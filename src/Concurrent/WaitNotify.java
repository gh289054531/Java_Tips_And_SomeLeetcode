package Concurrent;
public class WaitNotify implements Runnable {
	private boolean flag = false;

	public synchronized void a() {
		p("t1 enter into a()");
		while (!flag) { // ��while��ԭ�򣬱������InterruptedExceptionʱ���߳�û�гɹ�wait
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		p("t1 come to notify after wait:" + flag);
	}

	public synchronized void b() {
		p("t2 enter into b() to change flag to true");
		flag = true;
		this.notify();
	}

	public void run() {
		String name = Thread.currentThread().getName();
		if (name.equals("t1")) {
			a();
		} else {
			b();
		}
	} // ��һ���߳���ģ��2���߳�

	public static void main(String[] args) {
		WaitNotify twn = new WaitNotify();
		Thread t1 = new Thread(twn, "t1");
		// twn.a(); // ���߳���ס�������߳�wait�ˣ��Ͳ��ܽ��к���Ĵ�����
		Thread t2 = new Thread(twn, "t2");
		t1.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();
	}

	private static void p(Object o) {
		System.out.println(o);
	}
}