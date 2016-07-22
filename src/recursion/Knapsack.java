package recursion;

public class Knapsack {

	//http://www.es.ele.tue.nl/education/5MC10/Solutions/knapsack.pdf
	
	public static int knapsack(int wt[], int v[], int W) {
		
		int iw[][] = new int[v.length+1][W+1];
		int keep[][] = new int[v.length+1][W+1];

		for(int i=1; i<=v.length;i++) {
			for(int w=1; w<=W; w++) {
				if (wt[i-1] > w) iw[i][w] = iw[i-1][w];
				else {
					if(iw[i-1][w] > (iw[i-1][w-wt[i-1]] + v[i-1])) {
						iw[i][w] = iw[i-1][w] ;
						keep[i][w] = 0;
					}
					else {
						iw[i][w] = iw[i-1][w-wt[i-1]] + v[i-1];
						keep[i][w] = 1;
					}
				}
			}
		}

		int w=W;
		for(int i=v.length; i>0;i--) {
			if(keep[i][w] == 1){
				System.out.println(v[i-1]);
				w = w - wt[i-1];
			}
		}

		return iw[v.length][W];

	}
	
	public static void main(String[] args) {
		int [] v = new int [] { 10,20,30};
		int [] w = new int [] {1,2,4};
		int W = 5;
		System.out.println(knapsack(w, v, W));
	}
}
