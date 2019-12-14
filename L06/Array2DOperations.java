package L06;

import java.util.Scanner;

public class Array2DOperations {
	static Scanner sn = new Scanner(System.in);

	public static void main(String[] args) {
//		int[][] arr =  rectinput();
		int [][] arr = jarr();
		display(arr);


	}

	private static int[][] jarr() {
		System.out.println("Rows?");
		int row = sn.nextInt();
		int[][] arr = new int[row][];
		for(int r = 0 ; r<arr.length;r++) {
			System.out.println("Col?");
			int col = sn.nextInt();
			arr[r]= new int[col];
			for(int c =0; c<arr[r].length;c++) {
				System.out.println(r+"-"+c);
				arr[r][c]= sn.nextInt();
			}
			
		}
		
		return arr;
	}

	private static void display(int[][] arr) {
		for(int r = 0 ; r<arr.length;r++) {
			for(int c =0; c<arr[r].length;c++) {
				System.out.print(" "+arr[r][c]+" ");
			}
			System.out.println();
			
		}

		
	}

	private static int[][] rectinput() {
		System.out.println("Rows?");
		int row = sn.nextInt();
		System.out.println("Col?");
		int col = sn.nextInt();
		int[][] arr = new int[row][col];
		for(int r = 0 ; r<arr.length;r++) {
			for(int c =0; c<arr[0].length;c++) {
				System.out.println(r+"-"+c);
				arr[r][c]= sn.nextInt();
			}
			
		}
		return arr;
		
		
	}
	

}
