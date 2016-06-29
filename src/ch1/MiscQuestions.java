package ch1;

import java.util.*;

public class MiscQuestions {
	
	public boolean hasUniqueCharacters(String s) {
		if (s==null) return false;
		char c[] = s.toCharArray();
		Map<Character, Boolean> m = new HashMap<Character, Boolean>();
		
		for (char ch: c) {
			if (m.get(ch) == null)
				m.put(ch, true);
			else return false;
		}
		return true;
	}
	
	public String compress(String s){
		if (s==null) return null;
		
		char [] chArr = s.toCharArray();
		StringBuilder b = new StringBuilder();
		int i=0;
		while (i < s.length()) {
			b.append(chArr[i]);
			int j = 1;
			while ((j+i) < s.length() && chArr[i+j] == chArr[i])
				j++;
			b.append(j);
			i = i+j;
		}
		String retStr = b.toString();
		if((retStr.length()/2) == s.length()) return s;
		return retStr;
	}

	
	public String replaceSpace(String s)
	{
		if (s==null || s.length() == 0) return null;
		char [] cArr = s.toCharArray();
		int numBlanks = 0;
		int lastCharPos = cArr.length -1;
		
		while (cArr[lastCharPos] == ' ')  lastCharPos--;
		
		for(int i=0; i <=lastCharPos; i++) 
		{
			if(cArr[i]==' ') numBlanks++;
		}
		
		int numBlanksReplaced = numBlanks;
		for(int i=lastCharPos;i>=0;i--)
		{
			if(cArr[i] == ' ')
			{
				int num = 2*(numBlanksReplaced -1);
				cArr[i+num] = '%';
				cArr[i+num+1] = '2';
				cArr[i+num+2] = '0';
				numBlanksReplaced--;
			}
			else
				cArr[i+2*numBlanksReplaced] = cArr[i];
		}
		return new String(cArr);
	}
	
	public int [][] clearRowsAndColumns(int [][] x) {
		
		
		boolean firstRowHasZero = false;
		boolean firstColHasZero = false;
		
		
		// for i =0 to x.length. if c[i][0] == 0 for j=0 to c[i].length c[i][j]=0
		// for j= 0 to x[0].length if c[0][j] == 0 for i=0 to x.length c[i][j] = 0
		
		// if a cell (i,j) has 0 then set c(i,0) = 0 and c(0,j) = 0;
		for(int i=0;i<x.length;i++)
		{
			for (int j=0;j<x[i].length;j++)
			{
				if(x[i][j] == 0) {
					if(i==0) firstRowHasZero = true;
					if(j==0) firstColHasZero = true;
					x[i][0] = 0;
					x[0][j] = 0;
				}
			}
		}

		//for row 2 to last. if first col is 0 then set 2nd col to last col to 0
		for (int i=1; i < x.length;i++){
			if(x[i][0] == 0) {
				for(int j=1; j<x[i].length;j++)
					x[i][j] = 0;
			}
		}
		
		//for col 2 to last. if first row is 0 then set 2nd row to last row to 0.
		for (int j=1; j < x[0].length;j++){
			if(x[0][j] == 0) {
				for(int i=1; i< x.length;i++)
					x[i][j] = 0;
			}
		}
		
		//if first col or row had zeros. then set it to zero.
		if(firstColHasZero) {
			for (int i=0; i<x[0].length;i++)
				x[i][0] = 0;
		}
		if(firstRowHasZero) {
			for (int i=0; i<x[0].length;i++)
				x[0][i] = 0;
		}
			
		return x;
	}
	
	
	public int[][] rotateRight(int[][] x) {
		int N = x.length;
		int numLayers = N/2;

		for(int l=1; l<=numLayers;l++) {
			int startIdx = l -1;
			int endIdx = N-l;

			for(int i=startIdx; i<=endIdx;i++) {
				int top = x[l-1][i];
				x[l-1][i] = x[N-l-i][i];
				x[N-l-i][i] = x[N-l-i][N-l-i];
				x[N-l-i][N-l-i] = x[l-1][N-l-i];
				x[l-1][N-l-i] = top;
			}
		}
		return x;
	}
	
	public void printMatrix(int [][] x)
	{
		for(int i=0; i < x.length; i++) {
			System.out.println("\n");
			for(int j=0;j<x[i].length; j++) 
				System.out.print(x[i][j]);
		}
		System.out.println("\n----");
			
	}
	
	public static void main(String[] args) {
		
		MiscQuestions q = new MiscQuestions();
//		System.out.println(q.hasUniqueCharacters("abcb"));
//		System.out.println(q.replaceSpace(" a b cd      "));
//		System.out.println(q.replaceSpace(" a   "));
		int [][] m = new int[][] { {1,2,3}, {4,5,6}, {7,8,9}};
//		int [][] m = new int[][] { {1,2},{3,4}};
		q.printMatrix(m);
		
		int [][] r = q.rotateRight(m);
		q.printMatrix(r);

	}

}
