package L24;

import L23.cars;

public class ClientGenricll {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		cars[] car = new cars[5];
		car[0] = new cars(1000, 20, "Black");
		car[1] = new cars(100, 203, "Blue");
		car[2] = new cars(2000, 202, "Red");
		car[3] = new cars(3000, 201, "Grey");
		car[4] = new cars(4000, 200, "Green");
		GenericLinklist<cars> ll = new GenericLinklist<cars>();
		ll.addLast(car[0]);
		ll.addLast(car[1]);
		ll.addLast(car[2]);
		ll.addLast(car[3]);
		ll.addLast(car[4]);
		ll.display();
		

	}

}
