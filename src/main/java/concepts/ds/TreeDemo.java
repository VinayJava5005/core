package concepts.ds;

import adt.queue.QueueArrayImpl;
import adt.tree.BinaryTree;
import adt.tree.Node;

import java.util.Optional;
import java.util.Random;

/**
 * Created by pradeep on 19/6/16.
 */
public class TreeDemo {


    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTree.getInstance();
        Optional<Node> rootNode = createTree(binaryTree);

        printTree(rootNode);
    }

    private static void printTree(Optional<Node> rootNode) {
        QueueArrayImpl<Node> queueArray = new QueueArrayImpl<Node>();

        if (rootNode.isPresent()) {
            queueArray.push(rootNode.get());
            while (!queueArray.isEmpty()) {
                Node node = (Node) queueArray.remove();
                if (node != null) {
                    System.out.println(node.getData());
                    queueArray.push(node.getLeftNode());
                    queueArray.push(node.getRightNode());
                } else {
                    System.out.println(node);
                }
            }
        }

    }

    private static Optional<Node> createTree(BinaryTree binaryTree) {
        Random random = new Random();
        int numberOfNodes = 10;
        Optional<Node> rootNode = Optional.ofNullable(null);
        while (numberOfNodes > 0) {
            int data = random.nextInt(100);
            Optional<Node> newNode = Optional.of(new Node(data, null, null));
            rootNode = Optional.of(binaryTree.insertNode(rootNode, newNode));
            numberOfNodes--;
        }

        return rootNode;
    }
}
