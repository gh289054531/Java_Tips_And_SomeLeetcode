package PrintABCConcurrent;

public class Main {
	public final static int ITER = 10;

	public static void main(String[] args) throws InterruptedException {
		Printer A = new Printer('a');
		Printer B = new Printer('b');
		Printer C = new Printer('c');
		A.next = B;
		B.next = C;
		C.next = A;
		new Thread(A).start();
		new Thread(B).start();
		new Thread(C).start();
		Thread.sleep(100);
		synchronized (A) {
			A.notify();
		}
	}
}

class Printer implements Runnable {
	Printer next;
	char val;

	public Printer(char val) {
		this.val = val;
	}

	@Override
	public void run() {
		for (int i = 0; i < Main.ITER; i++) {
			synchronized (this) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(this.val);
				synchronized (next) {
					next.notify();
				}
			}
		}
	}
}
