package L25;

import L23.cars;

public class HeapGClient {

	public static void main(String[] args) {
		HeapGenric<cars> heapG = new HeapGenric<cars>();
		cars[] car = new cars[5];
		car[0] = new cars(1000, 20, "Black");
		car[1] = new cars(100, 203, "Blue");
		car[2] = new cars(2000, 202, "Red");
		car[3] = new cars(3000, 201, "Grey");
		car[4] = new cars(4000, 200, "Green");
		for(int i = 0 ; i<5 ; i++) {
			heapG.add(car[i]);
		}
		while(!heapG.isEmpty()) {
			System.out.println(heapG.remove());
		}

	}

}
