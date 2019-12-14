package L12;

public class Coinoss {

	public static void main(String[] args) {
		int[] arr = {2,3,5,6};
		String str = "";
		toss(10, arr, 0,str);

	}
	public static void toss(int total , int[] arr , int i, String ans) {
		if(total==0) {
			System.out.println(ans);
			return;
		}
		if(total<0) {
			return;
		}
		for(; i<arr.length ; i++) {
			
			toss(total-arr[i], arr, i, ans+arr[i] );
		}
	}

}
