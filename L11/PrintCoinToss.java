package L11;

public class PrintCoinToss {

	public static void main(String[] args) {
		printCoinToss(3, "");

	}
	public static void printCoinToss(int ques,String ans) {
		if(ques==0) {
			System.out.println(ans);
			return;
		}
		printCoinToss(ques-1, ans+"H");
		printCoinToss(ques-1, ans+"T");
	}
}
