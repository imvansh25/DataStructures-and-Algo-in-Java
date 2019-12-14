package L04;

import java.util.Scanner;

public class FarenaiteToCelcius {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n1 = in.nextInt();
		int n2 = in.nextInt();
		int n3 = in.nextInt();
		int count=n1;
		while(count<=n2) {
			int c= (int)((5.0/9)*(count-32));
			System.out.println(count +"\t"+c);
			count+=n3;

		}
	}
}
