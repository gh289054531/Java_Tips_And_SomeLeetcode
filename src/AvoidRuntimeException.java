public class AvoidRuntimeException {
	public static void main(String[] args) {
		try {
			System.out.println(1 / 0);
		} finally {
			return;
		}
	}
}