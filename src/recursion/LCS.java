package recursion;

public class LCS {
	/**
	 * http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/
	 * http://www.geeksforgeeks.org/printing-longest-common-subsequence/
	 * https://rosettacode.org/wiki/Longest_common_subsequence#Dynamic_Programming_2
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static String getLCS(String a, String b) {
		
		char [] x = a.toCharArray();
		char [] y = b.toCharArray();

		int[][] lcs = new int[x.length+1][y.length+1];

		for(int i=1;i <= x.length; i++) {
			for(int j=1; j <= y.length; j++) {
				if(x[i-1]==y[j-1]) lcs[i][j] = lcs[i-1][j-1] + 1;
				else {
					lcs[i][j] = Math.max(lcs[i][j-1], lcs[i-1][j]);
				}
			}
		}

		StringBuffer buf = new StringBuffer();
		for(int i=x.length, j=y.length; i>0 && j>0;) {
			if(x[i-1] == y[j-1]) {
				buf.append(x[i-1]);
				i--;
				j--;
			}
			else if(lcs[i-1][j] > lcs[i][j-1])
				i--;
			else 
				j--;
			
		}
		return buf.reverse().toString();
	

	}
	
	public static void main(String[] args) {
		System.out.println(LCS.getLCS("ABCDGH", "AEDFHR"));
		System.out.println(LCS.getLCS("AGGTAB", "GXTXAYB"));
	}
}
