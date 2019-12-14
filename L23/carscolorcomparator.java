package L23;

import java.util.Comparator;

public class carscolorcomparator implements Comparator<cars> {

	@Override
	public int compare(cars t, cars o) {
		return t.color.compareTo(o.color);
	}

}
