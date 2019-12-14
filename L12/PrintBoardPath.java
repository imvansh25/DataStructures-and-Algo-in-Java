package L12;

public class PrintBoardPath {

	public static void main(String[] args) {
		Boapath(0, 10, "");

	}

	public static void Boapath(int curr, int end, String ans) {
		if(curr==end) {
			System.out.println(ans);
			return;
		}
		if(curr>end) {
			return;
		}
		for (int i = 1; i <= 6; i++) {
			Boapath(curr+i, end, ans+i);

		}
	}

}
