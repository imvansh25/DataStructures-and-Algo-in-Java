package L04;

import java.util.Scanner;

public class Amstrong {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("ENTER Lower no. :-");
		int n1 = in.nextInt();
		System.out.println("ENTER Higher no. :-");
		int n2 = in.nextInt();
		for(int i=n1;i<=n2;i++) {
			if(IsArmstrong(i)) {
				System.out.println(i);
			}
		}
		
		
		

	}
	public static int length(int n) {
		int count=0;
		while(n!=0) {
			count++;
			n=n/10;
		}
		return count;
		
		
	}
	public static boolean IsArmstrong(int n1) {
		
		int len = length(n1);
		int piggy=0;
		int n=n1;
		while(n!=0) {
			int c=n%10;
			n=n/10;
			piggy+=(int)Math.pow(c, len);
		}
		if(piggy==n1) {
			return true;
		}else {
			return false;
		}
		
	}
	
}
