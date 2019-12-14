package L11;

public class SSAscii {

	public static void main(String[] args) {
		AsciiSS("abc", "");

	}
	public static void AsciiSS(String ques,String ans) {
		if(ques.length()==0) {
			System.out.println(ans);
			return;
		}
		char ch = ques.charAt(0);
		String ros = ques.substring(1);
		AsciiSS(ros, ans);
		AsciiSS(ros, ans+ch);
		String str = ans+(int)ch;
		AsciiSS(ros, str);
	}

}
