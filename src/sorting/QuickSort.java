package sorting;

public class QuickSort {
	public void qsort(int[] input, int start, int end) {

		int pivot = partition(input, start, end);
		if(start < (pivot-1))
			qsort(input, start, pivot-1);
		if(end > pivot)
			qsort(input, pivot, end);
	}

	private int partition(int[] a, int start, int end) {

		int p = (start + end) / 2;

		int l = start;
		int r = end;

		while (l <= r) {
			while (a[l] < a[p])
					l++;
			while (a[r] > a[p])
					r--;

			if (l<=r) {
				int tmp = a[l];
				a[l] = a[r];
				a[r] = tmp;
				l++;
				r--;
			}
		}
		return l;

	}
	
	public static void main(String[] args) {
		QuickSort s= new QuickSort();
		
		int [] data = new int [] {4,2,1,0,3,6,7,8,5,9,10};
		s.qsort(data,0, data.length-1);
		for(int i=0;i < data.length;i++) {
			System.out.println(data[i]);
		}
	}

}
