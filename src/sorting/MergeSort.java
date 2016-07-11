package sorting;

public class MergeSort {
	
	public void sort(int [] input) {
		if (input == null || input.length == 0) return;
		
		merge_sort(input, 0, input.length -1);
		
	}

	private void merge_sort(int [] input, int start, int end) {
		
		if(start >= end) return;
		
		int mid = (start+end)/2;
		merge_sort(input, start, mid);
		merge_sort(input, mid+1, end);
		merge(input, start, mid, end);
	}

	private void merge(int [] input, int start, int mid, int end) {
		
		int [] tmp = new int[(end-start)+1];
		
		for(int i=start; i<=end;i++) 
			tmp[i-start] = input[i];
			
		int left = start;
		int right = mid+1;
		int current = 0;
		
		while(left <= mid && right <=end) {
			if(input[left] < input[right])
				tmp[current++] = input[left++];
			else
				tmp[current++] = input[right++];
		}
		if(left <= mid){
			for (int i=left; i<=mid;i++)
				tmp[current++] = input[left++];
		}
		if(right <= end){
			for (int i=right; i<=end;i++)
				tmp[current++] = input[right++];
		}
		
		//now put tmp back to input
		for(int i=start; i<=end;i++) 
			input[i] = tmp[i-start];
		
	}

	public static void main(String[] args) {
		MergeSort s= new MergeSort();
		
		int [] data = new int [] {2,1,3,6,4,7};
		s.sort(data);
		for(int i=0;i < data.length;i++) {
			System.out.println(data[i]);
		
		}
	}
}
