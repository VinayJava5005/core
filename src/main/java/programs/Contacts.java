package programs;

import adt.trie.Dictionary;
import adt.trie.Node;

import java.util.Scanner;

/**
 * Created by pradeep on 7/6/17.
 */

/*

4
add hack
add hackerrank
find hac
find hak

 */
public class Contacts {

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary(new Node());

        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        while (testCases > 0) {

            String[] inputs = scanner.nextLine().split(" ");

            switch (inputs[0]) {
                case "add":
                    dictionary.addWord(inputs[1]);
                    break;

                case "find":
                    System.out.println(dictionary.wordsCount(inputs[1]));
                    break;

            }
            testCases--;
        }
    }
}
