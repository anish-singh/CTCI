package hard;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class MedianCalculator {
	
	PriorityQueue<Integer> maxQ;
	PriorityQueue<Integer> minQ;

	public MedianCalculator() {
		maxQ = new PriorityQueue<Integer>(10,
			new Comparator<Integer>() { 
				public int compare(Integer a, Integer b) { return b-a;}
			});

		minQ = new PriorityQueue<Integer>();
	}


	public void add(int x) {

		if(maxQ.size() == minQ.size())
			addToMaxQ(x);
		else
			addToMinQ(x);
	}

	private void addToMaxQ(int x) {
		if(maxQ.size() == 0) {
			maxQ.offer(x);
			return;
		}

		int topMaxQ = maxQ.peek();
		
		if(topMaxQ >=x || minQ.isEmpty()) {
			maxQ.offer(x);
		}
		else {
			int topMinQ = minQ.poll();
			maxQ.offer(topMinQ);
			minQ.offer(x);
		}
 	}

 	private void addToMinQ(int x) {
		if(minQ.size() == 0) {
			minQ.offer(x);
			return;
		}

		int topMinQ = minQ.peek();
		
		if(topMinQ < x) {
			minQ.offer(x);
		}
		else {
			int topMaxQ = maxQ.poll();
			minQ.offer(topMaxQ);
			maxQ.offer(x);
		}
 	}
 	
 	public float getMedian() {
 		if(maxQ.size() > minQ.size())
 			return maxQ.peek();
 		else
 			return (float)(maxQ.peek() + minQ.peek()) /2;
 	}

 	private void printQueue(PriorityQueue<Integer> q) {
 		Iterator<Integer> itr = q.iterator();
 		while(itr.hasNext()) {
 			System.out.println(itr.next());
 		}

 	}
 	
 	public static void main(String[] args) {
		MedianCalculator m = new MedianCalculator();
		m.add(1);
		System.out.println("Median = " + m.getMedian());
		m.add(2);
		System.out.println("Median = " + m.getMedian());
		m.add(3);
		System.out.println("Median = " + m.getMedian());
		m.add(4);
		System.out.println("Median = " + m.getMedian());
		m.add(5);
		System.out.println("Median = " + m.getMedian());
		m.add(6);
		System.out.println("Median = " + m.getMedian());
		
//		System.out.println("Max Queue...");
//		m.printQueue(m.maxQ);
//		
//		System.out.println("Min Queue...");
//		m.printQueue(m.minQ);
		
	}

}