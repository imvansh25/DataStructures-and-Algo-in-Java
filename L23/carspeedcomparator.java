package L23;

import java.util.Comparator;

public class carspeedcomparator implements Comparator<cars> {

	@Override
	public int compare(cars t, cars o) {
		return t.speed-o.speed;
	}

}
