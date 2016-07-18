package sorting;

public class QuickSelect {
	
	
	public int findKth(int [] a, int left, int right, int k) {

		if(left == right) return a[left];

		int pivot = (left + right) / 2;
		int locOfPivot=partition(a, left, right, a[pivot]);

		if(locOfPivot == k)
			return a[locOfPivot];
		if(locOfPivot > k)
			return findKth(a, left, locOfPivot-1, k);
		else
			return findKth(a, locOfPivot+1, right, k);

	}

	private int partition(int [] a, int left, int right, int pivot) {

		while(left <= right) {
			while (a[left] < pivot)
				left++;
			while (a[right] > pivot)
				right--;

			if (left<=right) {
				int tmp = a[left];
				a[left] = a[right];
				a[right] = tmp;
				left++;
				right--;
			}
		}
		return left;

	}

	public static void main(String[] args) {
		int [] a= new int [] {4,2,1,0,3,6,7,8,5,9,10};
//		int [] a= new int [] {4,2};
		
		QuickSelect q= new QuickSelect();
		
		System.out.println(q.findKth(a, 0, a.length-1, 0));

	}

}
