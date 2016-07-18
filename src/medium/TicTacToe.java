package medium;

public class TicTacToe {

	// 1 - X has won
	// 0 - O has won
	// -1 no one has one

	public static int hasWon(int [][] b) {

		//check if any row has all 0s or 1s
		for(int r=0;r < b.length;r++) {
			boolean match = true;
			for(int c=1; c < b.length; c++) {
				if(b[r][c] != b[r][0])  {
					match=false;
					break;
				}
			}
			if(match)
				return b[r][0];
		}

		//check if any col has all 0s or 1s
		for(int c=0;c < b.length;c++) {
			boolean match = true;
			for(int r=1; r < b.length; r++) {
				if(b[r][c] != b[0][c])  {
					match=false;
					break;
				}
			}
			if(match)
				return b[0][c];
		}

		//check if left diagonal has all 0s or 1s
		boolean match = true;
		for(int c=1;c < b.length;c++) {
			if(b[c][c] != b[0][0])  {
				match=false;
				break;
			}
		}
		if(match)
			return b[0][0];

		//check if right diagonal has all 0s or 1s
		match = true;
		for(int r=1;r < b.length;r++) {
			if(b[r][b.length-1-r] != b[0][b.length-1])  {
				match=false;
				break;
			}
		}
		if(match)
			return b[0][b.length-1];

		return -1;

	}
	
	public static void main(String[] args) {
		int [][] tictac = new int[][] {{0,0,1}, {1,1,0}, {1,0,1}};
		System.out.println(hasWon(tictac));
	}
}
