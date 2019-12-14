package L11;

import java.util.ArrayList;
import java.util.Scanner;

public class CoinToss {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		System.out.println(coin(n));

	}
	public static ArrayList<String> coin(int n) {
		if(n==0) {
			
			ArrayList<String> ans=new ArrayList<String>();
			ans.add(" ");
			return ans;
			
		}
		
		ArrayList<String> ans=new ArrayList<String>();  
		ArrayList<String> sub = coin(n-1);
		for(String val : sub) {
			ans.add("H"+val);
			ans.add("T"+val);
		}
		return ans;
	}

}
