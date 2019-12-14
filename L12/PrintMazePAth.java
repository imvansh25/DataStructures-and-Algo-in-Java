package L12;

import java.util.ArrayList;

public class PrintMazePAth {

	public static void main(String[] args) {
		maze(0, 0, 2, 2, "");
		
	}
	public static void maze(int cr, int cc, int er, int ec,String ans) {
		if(cr==er &&cc==er ) {
			System.out.print(ans+" ");
			return;
		}
		if(cr>er || cc>er) {
			return;
		}
		maze(cr+1, cc, er, ec, ans+"H");
		maze(cr, cc+1, er, ec, ans+"V");
	}
}
