package L23;

import java.util.Comparator;

import L05.Sorting;

public class GenericDemo {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		cars[] car = new cars[5];
		car[0] = new cars(1000, 20, "Black");
		car[1] = new cars(100, 203, "Blue");
		car[2] = new cars(2000, 202, "Red");
		car[3] = new cars(3000, 201, "Grey");
		car[4] = new cars(4000, 200, "Green");
		BubbleSort(car, new CarPriceComparator());
		display(car);
		BubbleSort(car, new carscolorcomparator());
		display(car);
		BubbleSort(car, new carspeedcomparator());
		display(car);

	}

	public static <T> void display(T[] arr) {
		for (T val : arr) {
			System.out.println(val);
		}
		System.out.println();
	}

	public static <T extends Comparable<T>> void BubbleSort(T[] arr) {
		for (int counter = 0; counter < arr.length - 1; counter++) {
			System.out.println("counter" + counter);
			for (int j = 0; j < arr.length - counter - 1; j++) {
				if (arr[j].compareTo(arr[j + 1]) > 0) {
					T temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;

				}
			}

		}
	}

	public static <T> void BubbleSort(T[] arr, Comparator<T> comp) {
		for (int counter = 0; counter < arr.length - 1; counter++) {
			for (int j = 0; j < arr.length - counter - 1; j++) {
				if (comp.compare(arr[j], arr[j + 1]) > 0) {
					T temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;

				}
			}

		}
	}

}
