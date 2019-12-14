package L03;

import java.util.Scanner;

public class Rotate {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("ENTER NO OF ROTATION :-");
		int n1 = in.nextInt();
		System.out.println("ENTER NUMBER :-");
		int n2 = in.nextInt();
		int len = 0;
		int piggy=n2;
		while(n2!=0)
		{
			len++;
			n2 = n2 / 10;
		}
		if(n1<0)
		{
			n1=n1%len;
			n1 = len + n1;
		}
		if (n1>len) {
			n1=n1%len;
		}
		int mul = (int) Math.pow(10, n1);
		int rem = piggy % mul;
		piggy=piggy/mul;
		rem*=(int)Math.pow(10, (len-n1));
		rem+=piggy;
		System.out.println(rem);
	}

	

}


