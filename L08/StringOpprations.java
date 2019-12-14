package L08;

public class StringOpprations {
	public static void main(String[] args) {
		String str = "nitin" ;
//		substring(str);
//		System.out.println(IsPalindrome(str));
		palindrome_substring(str);

	}

	public static void substring(String str) {
		for (int i = 0; i <= str.length(); i++) {
			for(int j = i+1 ; j<= str.length(); j++) {
				System.out.println(str.substring(i, j));
			}

		}

	}
	public static boolean IsPalindrome(String str) {
		for(int i = 0; i<((str.length()/2)); i++) {
			if(str.charAt(i)!=str.charAt(str.length()-1-i)) {
				return false;
			}
		}
		return true;
	}
	public static void palindrome_substring(String str) {
		for (int i = 0; i <= str.length(); i++) {
			for(int j = i+1 ; j<= str.length(); j++) {
				String str1 = str.substring(i, j);
			
				if(IsPalindrome(str1)) {
			
				System.out.println(str.substring(i, j));
				}
			}

		}
	
	
	}
}
