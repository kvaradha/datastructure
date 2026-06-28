package com.ds.basics.trees;

/**
 * Binary Search Tree
 *
 * @author Karthikeyan
 */
public class BinarySearchTree {

    public static class Node {
        Node left;
        Node right;
        int data;
    }

    /**
     * Add element to binary search tree.
     *
     * @param root Node
     * @param data int
     * @return Node
     */
    public static Node add(Node root, int data) {
        Node node = new Node();
        node.left = null;
        node.right = null;
        node.data = data;
        if(root == null) {
            root = node;
        } else {
            Node traverseNode = root;
            Node insertNode = null;
            while(traverseNode != null) {
                insertNode = traverseNode; // Track the previous node for insert.
                int rootData = traverseNode.data;
                if(data < rootData) {
                    traverseNode = traverseNode.left;
                } else {
                    traverseNode = traverseNode.right;
                }
            }
            if(insertNode.data > data) {
                insertNode.left = node;
            } else {
                insertNode.right = node;
            }
        }
        return root;
    }

    /**
     * Inorder Traversal.
     *
     * @param node Node
     */
    public static void inorder(Node node) {
        if(node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    /**
     * Find Depth.
     *
     * @param node Node
     * @return int
     */
    public static int findDepth(Node node) {
        if(node == null) {
            return 0;
        }
        int left = findDepth(node.left) + 1;
        int right =  findDepth(node.right) + 1;
        return Math.max(left,right);
    }

    public static void main(String []args) {
        Node root = null;
        root = add(root,4);
        root = add(root,2);
        root = add(root,7);
        root = add(root,1);
        root = add(root,3);
        root = add(root,5);
        inorder(root);
        System.out.println();
        System.out.println(findDepth(root));
    }
}
