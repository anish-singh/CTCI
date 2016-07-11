package bitwise;

public class Exercises {

	public static void insertMIntoN(int m, int n, int start, int end) {

		System.out.println("n=" + Integer.toBinaryString(n));
		System.out.println("m=" + Integer.toBinaryString(m));
		// clear start to end bits in N
		int r = -1 >>> (32 - end);
		System.out.println("r=" + Integer.toBinaryString(r));
		int l = 0;

		for (int i = 0; i <= start; i++)
			l |= (1 << i);
		System.out.println("l=" + Integer.toBinaryString(l));

		int mask = ~(l | r);
		System.out.println("mask=" + Integer.toBinaryString(mask));
		n = n & mask;
		System.out.println("n=" + Integer.toBinaryString(n));

		m = m << start;
		System.out.println("m=" + Integer.toBinaryString(m));
		
		n = n | m;
		
		System.out.println("n=" + Integer.toBinaryString(n));
	}
	
	public static void printBinOfDecimal(float num){
		
		if(num < 0 || num >1) {
			System.out.println("ERROR");
			return;
		}
		float f = num;
		StringBuilder b = new StringBuilder(".");
		int count= 0;
		while(f  > 0 && count<32){
			f *=2;
			if((f-1) >= 0) {
				b.append("1");
				f -= 1;
			}
			else
				b.append("0");
			count++;			
		}
		if(count >=32)
		{
			System.out.println("ERROR");
			return;
		}
		System.out.println(b);
		
	}
	
	public static void numBitsToFlip(int m, int n) {
		System.out.println("m=" + Integer.toBinaryString(m));
		System.out.println("n=" + Integer.toBinaryString(n));
		
		int flip = m ^n;
		System.out.println("n=" + Integer.toBinaryString(flip));
		
		int count = 0;
		for(count =0;flip >0; flip &=(flip-1), count++) {}
		
		System.out.println("count=" +count);
		
	}
	


	
	public static void main(String[] args) {
		numBitsToFlip(4,5);
	}
}
