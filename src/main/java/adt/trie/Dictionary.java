package adt.trie;

/**
 * Created by pradeep on 7/6/17.
 */
public class Dictionary {

    private Node head;

    public Dictionary(Node head) {
        this.head = head;
    }

    private Node prefixNode(Node node, char[] charArray, int index) {

        Node prefixNode;
        if (index == charArray.length - 1) {
            prefixNode = node.getNodes()[nodeIndex(charArray[index])];

            if (prefixNode != null) {
                prefixNode = node;
            }
        } else {
            prefixNode = node.getNodes()[nodeIndex(charArray[index])];

            if (prefixNode != null) {
                prefixNode = prefixNode(prefixNode, charArray, index + 1);
            }
        }
        return prefixNode;

    }

    public int wordsCount(String prefix) {

        int count = 0;

        Node prefixNode = prefixNode(head, prefix.toCharArray(), 0);

        if (prefixNode != null) {
            count = wordsCount(prefixNode);
        }
        return count;
    }

    private int wordsCount(Node prefixNode) {
        int count = prefixNode.isWord() ? 1 : 0;

        for (Node node : prefixNode.getNodes()) {
            if (node != null) {
                count += wordsCount(node);
            }
        }

        return count;
    }

    private int nodeIndex(char ch) {
        int charIndex = (int) ch;
        if (charIndex >= 65 && charIndex <= 90) {
            charIndex -= 65;
        } else if (charIndex >= 97 && charIndex <= 122) {
            charIndex -= 97;
        }
        return charIndex;
    }

    public String addWord(String word) {
        add(head, word.toCharArray(), 0);
        return word;
    }

    private static Node add(Node head, char[] charArray, int index) {

        Node[] nodes = head.getNodes();

        int charIndex = (int) charArray[index];

        if (charIndex >= 65 && charIndex <= 90) {
            charIndex -= 65;
        } else if (charIndex >= 97 && charIndex <= 122) {
            charIndex -= 97;
        }
        Node node = nodes[charIndex];

        if (node == null) {
            node = new Node();
        }

        if (charArray.length - 1 == index) {
            head.addNode(charIndex, node);
            head.setWord(true);
        } else {
            head.addNode(charIndex, add(node, charArray, index + 1));
        }

        return head;
    }
}
