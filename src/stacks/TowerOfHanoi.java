package stacks;

public class TowerOfHanoi {
	
	public static void solve(int N)
	{
		solveRecursive(N, 1, 3, 2);
	}
	
	
	
	private static void solveRecursive(int n, int from, int to, int using) {
		if (n == 1)  moveDisk(n, from, to);
		else
		{
			solveRecursive(n-1, from, using, to);
			moveDisk(n, from, to);
			solveRecursive(n-1, using, to, from);
		}
		
	}



	private static void moveDisk(int n, int from, int to) {
		System.out.println("Moving Disk #" + n + " from tower#" + from + " to tower#" +to);
		
	}



	public static void main(String[] args) {
		TowerOfHanoi.solve(3);
	}

}
