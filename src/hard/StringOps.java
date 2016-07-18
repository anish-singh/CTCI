package hard;

import java.util.Arrays;
import java.util.Comparator;

public class StringOps {
	
	
	public void sortDescByLength(String [] s){
		
		Arrays.sort(s, new Comparator<String>() {
				
				public int compare(String s1, String s2) {
					if(s1 == null && s2 == null) return 0;
					if(s1 == null) return s2.length();
					if(s2 == null) return -1*s1.length();
 					return s2.length() - s1.length();
				}


		});
	}

	public static void main(String[] args) {
		String [] strs = new String[] {null, "a", "abc", "bndrg"};
		
		StringOps s = new StringOps();
		s.sortDescByLength(strs);
		
		for(String str: strs)	
			System.out.print(str + ",");

	}

}
