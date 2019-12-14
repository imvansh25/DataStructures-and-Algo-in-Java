package L23;

import java.util.Comparator;

public class CarPriceComparator implements Comparator<cars> {

	@Override
	public int compare(cars t, cars o) {
		return o.price-t.price;
	}

}
