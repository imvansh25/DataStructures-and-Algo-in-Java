package L14;

public class NoofSubstringswhicharepalindrom {

	public static void main(String[] args) {
		palindromicsubstring("nitinn");

	}

	public static void palindromicsubstring(String str) {
		int count = 0;
		for (int axis = 0; axis < str.length(); axis++) {
			for (int orbit = 0; axis - orbit >= 0 && axis + orbit < str.length(); orbit++) {
				if (str.charAt(axis + orbit) == str.charAt(axis - orbit)) {
					count++;
				}
			}
		}
		for (double axis = 0.5; axis < str.length(); axis++) {
			for (double orbit = 0.5; axis - orbit >= 0 && axis + orbit < str.length(); orbit++) {
				if (str.charAt((int) (axis + orbit)) == str.charAt((int) (axis - orbit))) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

}
