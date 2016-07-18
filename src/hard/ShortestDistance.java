package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShortestDistance {
	private HashMap<String, ArrayList<Integer>> wordList;

	public ShortestDistance(List<String> words) {
		wordList = new HashMap<String, ArrayList<Integer>>();
		initializeWordList(words);
	}

	private void initializeWordList(List<String> words) {
		if (words == null)
			return;

		int count = 1;
		for (String w : words) {
			if (wordList.containsKey(w)) {
				ArrayList<Integer> l = wordList.get(w);
				l.add(count++);
			} else {
				ArrayList<Integer> l = new ArrayList<Integer>();
				l.add(count++);
				wordList.put(w, l);
			}
		}
	}

	public int getMinDistance(String w1, String w2) {
		if (w1 == null || w2 == null || !wordList.containsKey(w1)
				|| !wordList.containsKey(w2))
			return -1;

		ArrayList<Integer> w1Positions = wordList.get(w1);
		ArrayList<Integer> w2Positions = wordList.get(w2);

		int gMin = Integer.MAX_VALUE;

		for (int i : w1Positions) {
			int lMin = Integer.MAX_VALUE;
			for (int j : w2Positions) {
				if (Math.abs(i - j) < lMin) {
					lMin = Math.abs(i - j);
					if (lMin < gMin)
						gMin = lMin;
				}
				if (Math.abs(i - j) > lMin)
					break;
			}

		}
		return gMin;
	}
	
	public static void main(String[] args) {
		
		ArrayList<String> l = new ArrayList<String>();
		l.add("1");
		l.add("2");
		l.add("3");
		l.add("4");
		l.add("5");
		l.add("1");
		l.add("6");
		l.add("7");
		l.add("8");
		l.add("8");
		l.add("21");
		l.add("91");
		l.add("10");
		l.add("11");
		l.add("1");
		l.add("9");
		
		
		
		ShortestDistance s = new ShortestDistance(l);
		System.out.println(s.getMinDistance("9", "3"));
	}

}
