package medium;

public class Misc {

	public int maxInt(int a, int b) {

		int s = sign(a - b);
		//1 => negative.
		//0 =>positive.
		return a * flip(s) + b * s;

	}
	
	public int numZeros(int n) {
		if(n <5) return 0;
		int count =0;
		
		for(int i=5;i<=n;i+=5){
			int num = i;
			while(num/5 >0) {
				count++;
				num /=5;
			}
		}
		return count;
	}

	private int sign(int x) {
		return (x>>31) & 1 ;
	}

	private int flip(int x) {
		return x ^ 1;
	}
	
	public static void main(String[] args) {
		Misc m = new Misc();
		System.out.println(m.numZeros(26));
	}
}
