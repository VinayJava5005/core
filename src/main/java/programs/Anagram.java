package programs;

public class Anagram {

	static char[] word = "CATS".toCharArray();
	static int wordLength = 4;
	static int count = 0;

	public static void getAnagrams(int newLength) {
		if (newLength == 1) {
			return;
		}

		for (int index = 0; index < newLength; index++) {
			getAnagrams(newLength - 1);
			if (newLength == 2) {
				displayWord();
			}
			rotateWord(newLength);
		}
	}

	private static void rotateWord(int rightIndex) {
		int position = word.length - rightIndex;
		char leftMostChar = word[position];
		for (int index = position + 1; index < word.length; index++) {
			word[index - 1] = word[index];
		}
		word[word.length - 1] = leftMostChar;
	}

	private static void displayWord() {
		count++;
		System.out.println(word);
	}

	public static void main(String[] args) {
		getAnagrams(wordLength);
		System.out.println(count);
	}

}
