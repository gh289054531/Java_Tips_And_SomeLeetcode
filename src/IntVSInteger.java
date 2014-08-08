public class IntVSInteger {
	final static int SIZE = 1024 * 1024 * 10;

	public static void main(String[] args) {
		int[] arr = new int[SIZE];
		long start = System.currentTimeMillis();
		for (int i = 0; i < SIZE; i++) {
			arr[i] = i;
		}
		System.out.println(System.currentTimeMillis() - start);

		Integer[] arr1 = new Integer[SIZE];
		start = System.currentTimeMillis();
		for (int i = 0; i < SIZE; i++) {
			arr1[i] = i;
		}
		System.out.println(System.currentTimeMillis() - start);

	}

}
