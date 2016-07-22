package recursion;

public class MinEditDistance {

	public static int minEditDistance(String s1, String s2) {

		int m = s1.length();
		int n = s2.length();

		int[][] d = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++)
			d[i][0] = i;
		for (int j = 0; j <= n; j++)
			d[0][j] = j;

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1))
					d[i][j] = d[i - 1][j - 1];
				else
					d[i][j] = min(d[i - 1][j] +1, // remove
							d[i][j - 1] +1, // insert
							d[i - 1][j - 1] + 2); // replace
			}
		}
		
		return d[m][n];
	}

	private static int min(int a, int b, int c) {
		int min = (a < b) ? a : b;
		min = (min < c) ? min : c;
		return min;
	}

	public static void main(String[] args) {
		System.out.println(MinEditDistance.minEditDistance("b", "ab"));
	}
}
