package trees;

public class Trie {

	class TrieNode {
		public char c;
		public boolean isWord;
		public int prefixes;
		public TrieNode[] children;

		public TrieNode(char c) {
			this.c = c;
		}
	}

	TrieNode root = null;

	public Trie() {
		root = new TrieNode('\0');

	}

	private int getIndex(char c) {
		return c - 'a';
	}

	public void addWord(String w) {

		if (w == null || w.length() == 0)
			return;

		w = w.toLowerCase();

		char[] ch = w.toCharArray();
		TrieNode currNode = root;

		for (int i = 0; i < ch.length; i++) {
			char c = ch[i];
			if (currNode.children == null)
				currNode.children = new TrieNode[26];

			int idx = getIndex(c);
			if (currNode.children[idx] == null)
				currNode.children[idx] = new TrieNode(c);
			if (i == (ch.length - 1))
				currNode.children[idx].isWord = true;
			else
				currNode.children[idx].prefixes += 1;

			currNode = currNode.children[idx];
		}

	}

	public boolean isWord(String w) {
		if (w == null || w.length() == 0)
			return false;

		w = w.toLowerCase();
		char[] ch = w.toCharArray();
		TrieNode currNode = root;

		for (int i = 0; i < ch.length; i++) {
			char c = ch[i];
			int idx = getIndex(c);

			if (currNode.children == null || currNode.children[idx] == null)
				return false;
			currNode = currNode.children[idx];
			
			if (i == (ch.length - 1) && currNode.isWord)
				return true;

			
		}

		return false;

	}
	
	public boolean isPrefix(String w) {
		if (w == null || w.length() == 0)
			return false;
		w = w.toLowerCase();

		char[] ch = w.toCharArray();
		TrieNode currNode = root;

		for (int i = 0; i < ch.length; i++) {
			char c = ch[i];
			int idx = getIndex(c);

			if (currNode.children == null || currNode.children[idx] == null)
				return false;
			currNode = currNode.children[idx];
		}

		return true;
	}

	public int getNumWordsThisWordisPrefix(String w) {
		if (w == null || w.length() == 0)
			return 0;

		w = w.toLowerCase();

		char[] ch = w.toCharArray();
		TrieNode currNode = root;

		for (int i = 0; i < ch.length; i++) {
			char c = ch[i];
			int idx = getIndex(c);

			if (currNode.children == null || currNode.children[idx] == null)
				return 0;

			if (i == (ch.length - 1))
				return currNode.children[idx].prefixes;

			currNode = currNode.children[idx];
		}

		return 0;

	}
	
	private static Trie createSuffixTrie(String word) {
		
		Trie t = new Trie();
		for(int i=0; i < word.length();i++){
			String s= word.substring(i, word.length()-1);
			t.addWord(s);
		}
		return t;
		
	}
	
	public static void main(String[] args) {
		
		String word = "abcdefghijklmabcdefghijklmnopqust";
		//create a suffix trie
		Trie t= createSuffixTrie(word);
		
		System.out.println(t.isPrefix("abcdef"));
		System.out.println(t.isPrefix("jklo"));
		
		//search for sub words in the original word
	}

}