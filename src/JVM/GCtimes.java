package JVM;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xms30m -Xmx30m -Xmn10m -XX:+UseSerialGC -verbose:gc -XX:+PrintGCDetails
 * -XX:+PrintGCTimeStamps
 * 
 * -Xms30m -Xmx30m -Xmn10m -XX:+UseParallelGC -verbose:gc -XX:+PrintGCDetails
 * -XX:+PrintGCTimeStamps
 * 
 * @author pstar.zhangp
 * 
 */
public class GCtimes {
	public static void main(String[] args) {
		List<Object> caches = new ArrayList<Object>();
		for (int i = 0; i < 7; i++) {
			caches.add(new byte[1024 * 1024 * 3]);
		}
		caches.clear();
		for (int i = 0; i < 2; i++) {
			caches.add(new byte[1024 * 1024 * 3]);
		}
	}
}
