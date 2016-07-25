package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class LongestIncreasingTuples {
	
	class Tuple{
		int v1;
		int v2;

		Tuple(int v1, int v2) {
			this.v1 = v1;
			this.v2 = v2;
		}
		
		public String toString() {
			return this.v1 + "," + this.v2;
		}
	}
	
	public ArrayList<Tuple>  getLISTuples(Tuple [] t) {

		// sort by v2

		Arrays.sort(t, new Comparator<Tuple>() {
				@Override
				public int compare(Tuple o1, Tuple o2) {
					return o1.v2-o2.v2;
				}

		});
		
		for(int i=0;i < t.length;i++)
			System.out.println(t[i]);
		System.out.println("----");
			
		return lis(t);
		
	}
	
	
	public ArrayList<Tuple> lis(Tuple a[]) {
		int [] lis = new int [a.length];
		int [] lastIndex = new int[a.length];

		for(int i=0;i<a.length;i++) {
			lis[i] =1;
			lastIndex[i] = i;
		}

		for (int i=0; i < a.length; i++) {
		   for(int j=0;j<i;j++) {
		   		if(a[j].v1 < a[i].v1 && (lis[i] < lis[j] + 1)) {
		   			lis[i] = lis[j] + 1;
		   			lastIndex[i] = j;
		   		}
		   	}
		}

		int maxIndex = 0;
		int max = Integer.MIN_VALUE;
		for(int i=0;i<a.length;i++)
			if(lis[i] > max)  maxIndex = i;

		ArrayList<Tuple> l = new ArrayList<Tuple>();
		while(maxIndex >= 0) {
			l.add(a[maxIndex]);
			if(maxIndex == lastIndex[maxIndex]) break;
			maxIndex = lastIndex[maxIndex];
		}
		return l;
	}
	
	public static void main(String[] args) {
		LongestIncreasingTuples s = new LongestIncreasingTuples();
		
		Tuple [] t = new Tuple [] { s.new Tuple(65,100), s.new Tuple(70,150), s.new Tuple(56,90), s.new Tuple(75,190), s.new Tuple(60,95), s.new Tuple(68,110) };
		
		s.getLISTuples(t);
		
	}
}
