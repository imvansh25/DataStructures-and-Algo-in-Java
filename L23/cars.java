package L23;

public class cars implements Comparable<cars> {
	int speed;
	int price;
	String color;

	public cars(int speed, int price, String color) {
		this.speed = speed;
		this.color = color;
		this.price = price;
	}
	@Override
	public String toString() {
		return "S "+this.speed+" C "+this.color +" P "+this.price;
	}
	@Override
	public int compareTo(cars other) {
//		return other.price-this.price;
		return this.speed-other.speed;
//		return this.color.compareTo(other.color);
	}

}
