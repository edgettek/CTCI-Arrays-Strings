import java.util.ArrayList;

public class Chapter_1 {
	
	public static void main(String[] args) {
		
		ArrayList<String> words = new ArrayList<String>();
		
		words.add("Kyle");
		words.add("aaa");
		words.add("Hillary");
		words.add("Geronimo");
		words.add("Renato");
		words.add("aba");
		words.add("abc");
		
		for(String s : words) {
			System.out.println(s + " is unique? " + isUnique(s));
		}
		
	}
	
	/*
	 * Solution to P1.1 : implement an algorithm to see if a string has all unique characters
	 * 
	 * Runtime: O(N) where N is the number of characters in the string
	 */
	public static boolean isUnique(String word) {
		
		int[] letterCount = new int[128];
		
		word = word.toLowerCase();
		
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

}
