package hard;

public class Shuffle {
	
	
	public int [] shuffle(int [] a) {
		if (a==null || a.length == 0) return a;
		

		for(int i=1; i < a.length;i++) {
			
			int k = getRandomNum(0,i-1);
			int tmp = a[i];
			a[i] = a[k];
			a[k] = tmp;
		}
		
		return a;

	}
	
	private int getRandomNum(int min, int max) {
		if (min == max) return min;
		
		double rand = Math.random();
		return (int) (min + rand * (max - min) + 1);	
	}
	
	public static void main(String[] args) {
		int a [] = new int [] {1,3,4,5,6,7,8,10};
		Shuffle s = new Shuffle();
		int [] b = s.shuffle(a);
		for(int i: b)	
			System.out.print(i + ",");
	}

}
