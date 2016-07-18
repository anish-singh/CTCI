package recursion;

public class LIS {

	/**
	 * LIS[i] = max(LIS[j] +1) for j <i and a[j] < a[i]
	 *
	 */
	public static int getLIS(int [] a) {
		
		int [] LIS = new int[a.length];
		for(int i=0; i < a.length; i++)
			LIS[i] = 1;
		
		for(int i=0;i<a.length;i++) {
			for (int j=0; j < i;j++) {
				if(a[j] < a[i] && (LIS[j] + 1) > LIS[i])
					LIS[i] = LIS[j] + 1;
			}
		}
		int max = 0;
		for(int i=0;i< LIS.length; i++)
			if(LIS[i] > max) max = LIS[i];
		
		return max;
		
	}
	
	
	public static void main(String[] args) {
		int [] a = new int [] {22,4,6,3,10,5,3,12,1,14};
		int max = LIS.getLIS(a);
		System.out.println("Length of LIS=" + max);
	}
}
