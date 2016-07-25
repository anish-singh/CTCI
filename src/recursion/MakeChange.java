package recursion;

public class MakeChange {
	
	static int [] mc = new int [100];
	static int [] lastChange = new int [100];

	public static int makeChange(int n) {

		if(n < 0)  return Integer.MAX_VALUE;

		if(n == 0)  return 0;
		
		if(mc[n] != 0)  return mc[n];

		int [] coins = new int [] {1,5,10,25};
		
		for(int c:coins) {
			if(n==c) {
				return 1;
			}
		}

		int min = Integer.MAX_VALUE;

		for(int c: coins) {
			int v = makeChange(n-c);
			if(v < min) {
				min = v;
				lastChange[n] = n-c;
			}
		}
		
		mc[n] = min +1;

		return min +1;
	}
	
	public static void main(String[] args) {
		System.out.println(MakeChange.makeChange(74));
		
		int lc = lastChange[74];
		do{
			System.out.println(lc);
			lc = lastChange[lc];
		}while (lc >0);
	}
}
