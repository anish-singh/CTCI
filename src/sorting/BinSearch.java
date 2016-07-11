package sorting;

public class BinSearch {

	public boolean find(int[] input, int data) {

		if (input == null)
			return false;

		return binSearch(input, data, 0, input.length - 1);

	}

	private boolean binSearch(int[] input, int data, int start, int end) {
		if (start > end)
			return false;

		int mid = (start + end) / 2;

		if (input[mid] == data)
			return true;

		if (input[mid] > data)
			return binSearch(input, data, start, mid - 1);
		else
			return binSearch(input, data, mid + 1, end);

	}
	
	
	public boolean search(String [] strs, String str) {
		
		return binSearchStringsWithEmptyString(strs, str, 0, strs.length - 1);

	}


	private boolean binSearchStringsWithEmptyString(String [] strs, String s, int start, int end) {
		if (start > end)  return false;

		int mid = (start+end) / 2;

		if(strs[mid].equals(s))  return true;
		if(strs[mid].equals("")) {
			//find the new mid
			int l = mid-1;
			int r = mid +1;
			while(l>=start && r<=end) {
				if(!strs[l].equals("")) {
					mid = l;
					break;
				}
				if(!strs[r].equals("")) {
					mid = r;
					break;
				}
				l++;
				r--;
			}

		}
		if(strs[mid].compareTo(s) > 0)
			return binSearchStringsWithEmptyString(strs, s, start, mid);
		else
			return binSearchStringsWithEmptyString(strs,s,mid +1, end);

	}
	
	public static void main(String[] args) {
		BinSearch s= new BinSearch();
		
		String [] data = new String [] {"a","","","aa","","aaa","","aaaa",""};
		System.out.println(s.search(data, "abaa"));
	}
}
