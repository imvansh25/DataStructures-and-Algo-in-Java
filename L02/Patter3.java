package L02;

public class Patter3 {

	public static void main(String[] args) {
		int n = 5;
		int tr= 2*n-1;
		int row = 1;
		int nst=1;
		while(row<=tr) {
			int col=1;
			while (col<=nst) {
				System.out.print("*");
				col++;
			}
			System.out.println("");
			if(col<=tr-1) {
				nst+=2;
			}else {
				nst-=2;
			}
			row++;
		
			
		}

		

	}

}
