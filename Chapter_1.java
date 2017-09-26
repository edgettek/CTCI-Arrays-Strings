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
		
//		System.out.println("Are Kyle and elKy permutations? " + isPermutation("Kyle", "elKy"));
//		System.out.println("Are abca and baac permutations? " + isPermutation("abca", "baac"));
//		System.out.println("Are nope and hello permutations? " + isPermutation("nope", "hello"));
//		System.out.println("Are Abc and abc permutations? " + isPermutation("Abc", "abc"));
//		System.out.println("Are GOAT and TAOG permutations? " + isPermutation("GOAT", "TAOG"));
		
		// P1.4
		
//		ArrayList<String> palindromes = new ArrayList<String>();
//		
//		palindromes.add("Kyle");
//		palindromes.add("aaa");
//		palindromes.add("taco cat");
//		palindromes.add("racecar");
//		palindromes.add("not an option");
//		palindromes.add("helleh");
//		palindromes.add("rosh hashanah");
//		
//		for(String s : palindromes) {
//			System.out.println("\"" + s + "\"" + " can be permuted into a palindrome? " + isPermutationPalindrome(s));
//		}

		ArrayList<String> toBeCompressed= new ArrayList<String>();
		
		toBeCompressed.add("aaaa");
		toBeCompressed.add("aaabbbccaax");
		toBeCompressed.add("toby");
		toBeCompressed.add("ggggaagyccc");
		
		for(String s : toBeCompressed) {
			System.out.println("\"" + s + "\"" + " -> " + compressString(s));
		}
		
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

	public static boolean isPermutationPalindrome(String word) {
		
		word = word.toLowerCase();
		word = word.replace(" ", "");
		
		int [] charCount = new int[128];
		
		char current;
		int index = -1;
		for(int i = 0; i < word.length(); i++) {
			current = word.charAt(i);
			
			index = current;
			
			charCount[index]++;
			
			
		}
		
		int numOdd = 0;
		
		for(int i = 0; i < charCount.length; i++) {
			
			if(charCount[i] % 2 != 0) {
				if(numOdd == 0) {
					numOdd++;
				}
				else {
					return false;
				}
			}	
		}
		
		return true;
		
	}

	
	
	/*
	 *  Solution to P1.6 : to compress a String based on the number of recurring characters
	 *  
	 *  Runtime: O(n) where n is the length of the given string (each character in the string is indexed once)
	 *  
	 *  Space complexity: O(n). Worst case scenario the string has no repeating, adjacent characters and the StringBuilder
	 *  is of length 2n.
	 */
	public static String compressString(String word) {
		
		char[] chars = word.toCharArray();
		
		StringBuilder compressed = new StringBuilder();
		
		char lookingFor = chars[0];
		
		int count = 1;
		
		for(int i = 1; i < chars.length; i++) {
			if(lookingFor == chars[i]) {
				count++;
			}
			else {
				compressed.append(lookingFor);
				compressed.append(count);
				lookingFor = chars[i];
				count = 1;
			}
		}
		
		compressed.append(lookingFor);
		compressed.append(count);
		
		String result = compressed.toString();
		
		if(result.length() >= word.length()) {
			return word;
		}
		else {
			return result;
		}
		
	}
	
}
