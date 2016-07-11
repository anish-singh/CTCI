package recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Exercises {

	public static long getNumPaths(int x, int y, long[][] paths) {
		if (x < 0 || y < 0)
			return 0;
		if (x == 0 || y == 0)
			return 1;

		if (paths[x][y] != -1)
			return paths[x][y];

		paths[x][y] = getNumPaths(x - 1, y, paths)
				+ getNumPaths(x, y - 1, paths);

		return paths[x][y];
	}

	public static boolean hasMagic(int[] sArray, int begin, int end) {
		if (end < begin || begin < 0)
			return false;

		int mid = (begin + end) / 2;

		if (sArray[mid] == mid)
			return true;

		if (sArray[mid] > mid)
			return hasMagic(sArray, begin, mid - 1);
		else
			return hasMagic(sArray, mid + 1, end);
	}

	public static ArrayList<Set<Integer>> getAllSubsets(Set<Integer> input) {

		ArrayList<Set<Integer>> allSubsets = new ArrayList<Set<Integer>>();

		// add null set as the first subset.
		allSubsets.add(new HashSet<Integer>());

		for (Integer element : input) {
			ArrayList<Set<Integer>> currList = new ArrayList<Set<Integer>>(
					allSubsets);
			for (Set s : currList) {
				Set<Integer> newSet = new HashSet<Integer>(s);
				newSet.add(element);
				allSubsets.add(newSet);
			}
		}
		return allSubsets;

	}

	public static ArrayList<String> permutations(String original, int charIndex) {

		if (charIndex == 0) {
			ArrayList<String> ret = new ArrayList<String>();
			Character c = original.charAt(charIndex);
			ret.add(c.toString());
			return ret;
		}

		ArrayList<String> currPerms = permutations(original, charIndex - 1);
		char ch = original.charAt(charIndex);
		ArrayList<String> newPerms = new ArrayList<String>();
		for (String b : currPerms) {
			for (int i = 0; i < b.length(); i++) {
				StringBuilder str = new StringBuilder(b).insert(i, ch);
				newPerms.add(str.toString());
			}
			StringBuilder str = new StringBuilder(b).append(ch);
			newPerms.add(str.toString());
		}
		return newPerms;
	}


	public static void main(String[] args) {
		// long paths[][] = new long [41][41];
		// for(int i=0; i < paths.length;i++)
		// for (int j=0; j < paths.length;j++)
		// paths[i][j] = -1;
		//
		// System.out.println(getNumPaths(20,20, paths));

		// int[] nums = new int[] { -1, 0, 3, 4, 5, 6, 7 };
		// System.out.println(hasMagic(nums, 0, nums.length));

		// Set<Integer> s = new HashSet<Integer>();
		// s.add(1);
		// s.add(2);
		// s.add(3);
		//
		// getAllSubsets(s);

		// String input = "abcd";
		//
		// ArrayList<String> s = permutations(input, input.length() - 1);
		// for (String str : s)
		// System.out.println(str);


	}
}
