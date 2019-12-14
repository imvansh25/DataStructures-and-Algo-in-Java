package L24;

import java.util.HashMap;
import java.util.Set;

public class HAshmap_demo {

	public static void main(String[] args) {
		HashMap<String,Integer> map = new HashMap<>();
		map.put("India" , 10);
		map.put("Sl" , 20);
		map.put("Aus" , 1);
		System.out.println(map);
		System.out.println(map.get("Sl"));
		Set<String> keys = map.keySet();
		for(String key : keys) {
			System.out.println(key);
		}

	}

}
