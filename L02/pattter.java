package L02;

public class pattter {

	public static void main(String[] args) {
		int n = 5;
		int nst = 1;
		int nsp = n/2;
		int row = 1;
		while (row <= n) {
			int csp = 1;
			while (csp <= nsp) {
				System.out.print(" ");
				csp += 1;
			}
			int cst = 1;
			while (cst <= nst) {
				System.out.print("*");
				cst += 1;
			}
			if(row<=(n/2)) {
				nst--;
				nsp += 2;
			}else {
				nst++;
				nsp-=2;
				}
			row++;
			System.out.println("");


	}

}
}
