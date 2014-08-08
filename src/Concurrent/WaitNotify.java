package Concurrent;
public class WaitNotify implements Runnable {
	private boolean flag = false;

	public synchronized void a() {
		p("t1 enter into a()");
		while (!flag) { // 用while的原因，避免出现InterruptedException时，线程没有成功wait
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
	} // 用一个线程类模拟2个线程

	public static void main(String[] args) {
		WaitNotify twn = new WaitNotify();
		Thread t1 = new Thread(twn, "t1");
		// twn.a(); // 主线程锁住对象！主线程wait了，就不能进行后面的处理了
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