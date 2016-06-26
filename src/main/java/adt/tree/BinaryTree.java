package adt.tree;

import java.util.Optional;

/**
 * Created by pradeep on 19/6/16.
 */
public class BinaryTree {

    private static BinaryTree instance = new BinaryTree();

    private BinaryTree() {
    }

    public static BinaryTree getInstance() {
        return instance;
    }

    public Node insertNode(Optional<Node> rootNode, Optional<Node> newNode) {
        if (rootNode.isPresent()) {
            if (newNode.isPresent()) {
                insert(rootNode, newNode);
            } else {
                System.out.println("Nothing to insert as newNode value is null");
            }
        } else {
            if (newNode.isPresent()) {
                System.out.println("Inserting first node with value : " + newNode.get().getData());
                rootNode = newNode;
                rootNode.get().setLeftNode(null);
                rootNode.get().setRightNode(null);
            } else {
                System.out.println("Nothing to insert as newNode value is null");
            }
        }
        return rootNode.get();
    }

    private void insert(Optional<Node> rootNode, Optional<Node> newNode) {
        Node rNode = rootNode.get();
        Node nNode = newNode.get();

        while (rNode != null) {
            if (rNode.getData() > nNode.getData()) {
                if (rNode.getLeftNode() != null) {
                    rNode = rNode.getLeftNode();
                } else {
                    System.out.println("Inserting node at left with value : " + nNode.getData());
                    nNode.setLeftNode(null);
                    nNode.setRightNode(null);
                    rNode.setLeftNode(nNode);
                    break;
                }
            } else {
                if (rNode.getRightNode() != null) {
                    rNode = rNode.getRightNode();
                } else {
                    System.out.println("Inserting node at right with value : " + nNode.getData());
                    nNode.setLeftNode(null);
                    nNode.setRightNode(null);
                    rNode.setRightNode(nNode);
                    break;
                }
            }
        }
    }
}