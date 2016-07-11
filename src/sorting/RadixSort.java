package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class RadixSort {
	public void radixSort(int [] input) {
		
		if(input == null) return;
		
		//bins of arraylists
		HashMap<Integer,ArrayList<Integer>> buckets = new HashMap<Integer,ArrayList<Integer>>();

		//put the numbers in the right bins
		for(int i=0;i< input.length;i++) {
			int exp = 0;
			boolean added = false;
			while(!added) {
				if(buckets.get(exp) == null) {
					buckets.put(exp, new ArrayList<Integer>());
				}
				int num = input[i] / (int)Math.pow(10, exp+1);
				if(num == 0) {
					buckets.get(exp).add(input[i]);
					added = true;
				}
				exp++;
			}
		}
		

		//go thru the bins in order of exponent. Sort each list using counting sort.
		
		int count=0;
		for (int e=0; e < buckets.keySet().size();e++) {
			ArrayList<Integer> bucket = buckets.get(e);
			int [] a = new int [bucket.size()];
			int idx = 0;
			for(Integer x:bucket)
				a[idx++] = x;
			
			Arrays.sort(a);
			for(int i=0; i< a.length;i++)
				input[count++] = a[i];
		}

	
	}
	
	public static void main(String[] args) {
		RadixSort s= new RadixSort();
		
		int [] data = new int [] {321,44,33,35,421,0};
		s.radixSort(data);
		for(int i=0;i < data.length;i++) {
			System.out.println(data[i]);
		}
	}
		
}
