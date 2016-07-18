package hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LongestCompositeWord {

	public String findLongestCompositeWord(List<String> words) {

		
		Collections.sort(words, new Comparator<String>() {
			public int compare(String s1, String s2) {
				return s1.length() - s2.length();
			}
		});

		for (int i = (words.size() - 1); i >= 1; i--) {
			String longWord = words.get(i);
			if (isComposedOfSmallerWords(longWord, longWord, words))
				return longWord;
		}
		return "";
	}

	private boolean isComposedOfSmallerWords(String word, String orginal, List<String> all) {

		if (word == null || all == null)
			return false;

		for (String w : all) {
			if (w.equals(orginal))
				continue;
			if (word.startsWith(w)) {
				String remainingWord = word
						.substring(w.length(), word.length());
				if (remainingWord.length() == 0)
					return true;
				return isComposedOfSmallerWords(remainingWord, orginal, all);

			}
		}
		return false;

	}
	
	public static void main(String[] args) {
		LongestCompositeWord lc = new LongestCompositeWord();
		
		ArrayList<String> l = new ArrayList<String>();
		l.add("1");
		l.add("3");
		l.add("2");
		l.add("4");
		l.add("5");
		l.add("12");
		l.add("123");
		l.add("12345");
		l.add("9");
		
		System.out.println(lc.findLongestCompositeWord(l));

	}
}