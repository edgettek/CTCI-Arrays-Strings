import java.util.ArrayList;

public class Chapter_1 {
	
	public static void main(String[] args) {
		
		// P1.1
		
		ArrayList<String> words = new ArrayList<String>();
		
		words.add("Kyle");
		words.add("aaa");
		words.add("Hillary");
		words.add("Geronimo");
		words.add("Renato");
		words.add("aba");
		words.add("abc");
		words.add("Kk");
		
//		for(String s : words) {
//			System.out.println(s + " is unique? " + isUnique(s));
//		}
		
		// P1.2
		
		System.out.println("Are Kyle and elKy permutations? " + isPermutation("Kyle", "elKy"));
		System.out.println("Are abca and baac permutations? " + isPermutation("abca", "baac"));
		System.out.println("Are nope and hello permutations? " + isPermutation("nope", "hello"));
		System.out.println("Are Abc and abc permutations? " + isPermutation("Abc", "abc"));
		System.out.println("Are GOAT and TAOG permutations? " + isPermutation("GOAT", "TAOG"));

		
	}
	
	/*
	 * Solution to P1.1 : implement an algorithm to see if a string has all unique characters
	 * 
	 * Runtime: O(N) where N is the number of characters in the string
	 */
	public static boolean isUnique(String word) {
		
		int[] letterCount = new int[128];
		
		char [] chars = word.toCharArray();
		
		for(int i = 0; i < chars.length; i++) {
			int value = chars[i];
			
			if(letterCount[value] > 0) {
				return false;
			}
			else {
				letterCount[value]++;
			}

		}
		
		return true;
	}

	/*
	 * Solution to P1.2 : implement an algorithm to see if one string is a permutation of another
	 * 
	 * Runtime: O(N) where N is the length of the longer of the two input strings
	 */
	public static boolean isPermutation(String s_1, String s_2) {
		
		//Algorithm: count number of occurrences of each letter in each string, if # occurrences match then permutation!
		
		if(s_1.length() != s_2.length()) {
			return false;
		}
		
		int[] charCount = new int[128];
		
		char current;
		int index = -1;
		
		for(int i = 0; i < s_1.length(); i++) {
			current = s_1.charAt(i);
			
			index = current;
			
			charCount[index]++;	
		}
		
		for(int i = 0; i < s_2.length(); i++) {
			current = s_2.charAt(i);
			
			index = current;
			
			charCount[index]--;	
		}
		
		for(int i = 0; i < charCount.length; i++) {
			if(charCount[i] != 0) {
				return false;
			}
		}
		return true;
	}
}
