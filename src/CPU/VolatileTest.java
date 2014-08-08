package CPU;

public class VolatileTest {
	private static long value1;

	public static void increment1() {
		while (value1 < 100000000L) {
			value1++;
		}
	}

	private static volatile long value2;

	public static void increment2() {
		while (value2 < 100000000L) {
			value2++;
		}
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		increment1();
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		start = System.currentTimeMillis();
		increment2();
		end = System.currentTimeMillis();
		System.out.println(end - start);
	}
}
