package L11;

import java.util.ArrayList;
import java.util.Scanner;

public class PossibleParathesis {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		System.out.println(parathesis(n));

	}
	public static ArrayList<String> parathesis(int n){
		if(n==1) {
			ArrayList<String> ans = new ArrayList<>();
			ans.add("()");
			return ans;
		}
		 ArrayList<String> sub = parathesis(n-1);
		 ArrayList<String> ans = new ArrayList<>();
		 for(String val : sub ) {
			 ans.add("()"+val);
			 ans.add("("+val+")");
			 if(!ans.contains(val+"()")){
				 ans.add(val+"()");
			 }
			 
		 }
		 return ans;
	}

}
