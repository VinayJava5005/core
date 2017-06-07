package adt.trie;

/**
 * Created by pradeep on 7/6/17.
 */
public class Node {

    private Node[] nodes = new Node[26];
    private boolean isWord;

    public Node[] getNodes() {
        return nodes;
    }

    public Node addNode(int index, Node node) {
        nodes[index] = node;
        return nodes[index];
    }

    public boolean isWord() {
        return isWord;
    }

    public void setWord(boolean isWord) {
        this.isWord = isWord;
    }
}
