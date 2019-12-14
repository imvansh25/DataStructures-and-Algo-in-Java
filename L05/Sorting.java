package L05;

public class Sorting {

	public static void main(String[] args) {
		int[] arr = { 50, 30, 10, 25, 5 };
//		BubbleSort(arr);
//		display(arr);
		int[] arr1 = { 50, 30, 10, 25, 5 };
//		SelectionSort(arr1);
//		display(arr1);
		InsertionSort(arr1);
		display(arr1);

	}

	public static void BubbleSort(int[] arr) {
		for (int counter = 0; counter < arr.length - 1; counter++) {
			System.out.println("counter" + counter);
			for (int j = 0; j < arr.length - counter - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			display(arr);
		}
	}

	public static void SelectionSort(int[] arr) {
		for (int counter = 0; counter < arr.length - 1; counter++) {
			int min = counter;
			for (int j = counter + 1; j < arr.length; j++) {
				if (arr[j] > arr[min]) {
					min = j;

				}
			}
			int temp = arr[min];
			arr[min] = arr[counter];
			arr[counter] = temp;
		}
	}

	public static void InsertionSort(int[] arr) {
		for (int counter = 1; counter < arr.length; counter++) {
			int item = arr[counter];
			int j = counter - 1;
			while (j >= 0 && arr[j] > item) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = item;
		}
	}

	public static void display(int[] arr) {
		for (int val : arr) {
			System.out.print(val);
			System.out.print(" ");
		}
		System.out.println();
	}

}
