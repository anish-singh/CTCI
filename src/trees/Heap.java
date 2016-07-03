package trees;

public class Heap {
	
	private static int MAX_SIZE = 50;
	int [] heap = new int [MAX_SIZE];
	int size = 0;
	
	public void add(int item)
	{
		heap[++size] = item;
		moveUp(size);
	}
	
	private void moveUp(int index)
	{
		if(index == 1 || index == 0)  return;
		
		if(heap[index] < heap[index/2])
		{
			int tmp = heap[index];
			heap[index] = heap[index/2];
			heap[index/2] = tmp;
			moveUp(index/2);
		}
		return;
	}
	
	public int getMin()
	{
		if (size < 1) throw new RuntimeException("No Elements");
		int min = heap[1];
		
		heap[1] = heap[size];
		heap[size] = 0;
		size--;
		moveDown(1);
		
		return min;
		
	}
	
	private void moveDown(int index)
	{
		if(index >= size)  return;
		if(heap[index] > heap[index*2])
		{
			int tmp = heap[index];
			heap[index] = heap[index*2];
			heap[index*2] = tmp;
			moveUp(index*2);
		}
	}
	
	public void printHeap()
	{
		for(int i=1; i<=size;i++)
			System.out.println(heap[i]);
	}
	
	public static void main(String[] args) {
		Heap h = new Heap();
		h.add(4);
		h.add(3);
		h.add(5);
		h.add(7);
		h.add(2);
		
		h.printHeap();
		System.out.println("-----");
		
		System.out.println(h.getMin());
		System.out.println(h.getMin());
		System.out.println("-----");
		h.printHeap();
	}

}
