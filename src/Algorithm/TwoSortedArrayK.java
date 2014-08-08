package Algorithm;

public class TwoSortedArrayK {
	public static int Kth(int[] a, int[] b, int la, int ha, int lb, int hb,
			int k) {
		if (la > ha) {
			return b[lb + k - 1];
		}
		if (lb > hb) {
			return a[la + k - 1];
		}
		int mida = (la + ha) / 2;
		int midb = (lb + hb) / 2;
		int num = mida - la + midb - lb + 2;
		if (a[mida] <= b[midb]) {
			if (k < num) {
				return Kth(a, b, la, ha, lb, midb - 1, k);
			} else {
				return Kth(a, b, mida + 1, ha, lb, hb, k - (mida - la + 1));
			}

		} else {
			if (k < num) {
				return Kth(a, b, la, mida - 1, lb, hb, k);
			} else {
				return Kth(a, b, la, ha, midb + 1, hb, k - (midb - lb + 1));
			}
		}
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1 };
		int[] b = new int[] { 1 };
		System.out.println(Kth(a, b, 0, a.length - 1, 0, b.length - 1, 1));
		System.out.println(Kth(a, b, 0, a.length - 1, 0, b.length - 1, 2));
		System.out.println("---------------------------------");
		a = new int[] { 1 };
		b = new int[] { 2 };
		System.out.println(Kth(a, b, 0, a.length - 1, 0, b.length - 1, 1));
		System.out.println(Kth(a, b, 0, a.length - 1, 0, b.length - 1, 2));
		System.out.println("---------------------------------");

		a = new int[] { 2 };
		b = new int[] { 1 };
		System.out.println(Kth(a, b, 0, a.length - 1, 0, b.length - 1, 1));
		System.out.println(Kth(a, b, 0, a.length - 1, 0, b.length - 1, 2));
		System.out.println("---------------------------------");

		a = new int[] { 1, 2 };
		b = new int[] { 1 };
		System.out.println(Kth(a, b, 0, a.length - 1, 0, b.length - 1, 1));
		System.out.println(Kth(a, b, 0, a.length - 1, 0, b.length - 1, 2));
		System.out.println(Kth(a, b, 0, a.length - 1, 0, b.length - 1, 3));
		System.out.println("---------------------------------");

		a = new int[] { 2 };
		b = new int[] { 1, 2 };
		System.out.println(Kth(a, b, 0, a.length - 1, 0, b.length - 1, 1));
		System.out.println(Kth(a, b, 0, a.length - 1, 0, b.length - 1, 2));
		System.out.println(Kth(a, b, 0, a.length - 1, 0, b.length - 1, 3));
		System.out.println("---------------------------------");

		a = new int[] { 1, 2 };
		b = new int[] { 1, 2 };
		System.out.println(Kth(a, b, 0, a.length - 1, 0, b.length - 1, 1));
		System.out.println(Kth(a, b, 0, a.length - 1, 0, b.length - 1, 2));
		System.out.println(Kth(a, b, 0, a.length - 1, 0, b.length - 1, 3));
		System.out.println(Kth(a, b, 0, a.length - 1, 0, b.length - 1, 4));
		System.out.println("---------------------------------");

		a = new int[] { 1, 2, 3 };
		b = new int[] { 4, 5 };
		System.out.println(Kth(a, b, 0, a.length - 1, 0, b.length - 1, 1));
		System.out.println(Kth(a, b, 0, a.length - 1, 0, b.length - 1, 2));
		System.out.println(Kth(a, b, 0, a.length - 1, 0, b.length - 1, 3));
		System.out.println(Kth(a, b, 0, a.length - 1, 0, b.length - 1, 4));
		System.out.println(Kth(a, b, 0, a.length - 1, 0, b.length - 1, 5));

	}
}
