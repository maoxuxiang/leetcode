package leetcode;

public class test {
	
	public static int testStr(String str) {

		int i = 0;
		int count = 0;
		while (i < str.length()) {
			if (str.charAt(i) == ' ') {
				count ++;
			//	return;
			}
			i++;
		}
		System.out.print(i);
		return count;
	}
	
	
	public static void main(String[] args) {
		System.out.print(testStr("  qq"));
	}

}
