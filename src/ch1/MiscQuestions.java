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
		//copy the matrix
		int [][] y = new int [x.length][];
		for (int i=0;i<x.length;i++)
		{
			y[i] = new int[x[i].length];
			for (int j=0; j<x[i].length;j++)
				y[i][j] = x[i][j];
		}
		
		for(int i=0;i<x.length;i++)
		{
			for (int j=0;j<x.length;j++)
			{
				if(x[i][j] == 0) {
					for(int c=0; c<y[i].length;c++)
						y[i][c] = 0;
					for(int r=0; r<y.length;r++)
						y[r][j] = 0;
				}
			}
		}
		return y;
	}
	
	
	public void printMatrix(int [][] x)
	{
		for(int i=0; i < x.length; i++) {
			System.out.println("\n");
			for(int j=0;j<x[i].length; j++) 
				System.out.print(x[i][j]);
		}
			
	}
	
	public static void main(String[] args) {
		
		MiscQuestions q = new MiscQuestions();
//		System.out.println(q.hasUniqueCharacters("abcb"));
//		System.out.println(q.replaceSpace(" a b cd      "));
//		System.out.println(q.replaceSpace(" a   "));
		int [][] m = new int[][] { {1,2,0}, {1,0,3}, {3,2,1}};
		q.printMatrix(m);
		System.out.println("----");
		int [][] r = q.clearRowsAndColumns(m);
		q.printMatrix(r);

	}

}
