package L12;

public class PrintLexicoCount {

	public static void main(String[] args) {
		LexicoCounting(0, 1000);

	}

	public static void LexicoCounting(int curr, int end) {
		if (curr == end) {
			return;
		}
		if (curr > end) {
			return;
		}
		System.out.println(curr);
		int i =0;
		if(curr==0) {
			i=1;
		}
		for(;i<=9;i++) {
			LexicoCounting(curr*10+i, end);
		}
	}

}
