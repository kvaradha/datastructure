package com.ds.basics.trees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Level Order Traversal. Complete Recursion.
 *
 * @author Karthikeyan
 */
public class LevelOrderTraversal {

    public static class Node {
        Node left = null;
        Node right = null;
        int data;
    }

    /**
     * Add data. Purely recursion.
     *
     * @param node Node
     * @param data int
     * @return Node
     *
     */
    public static Node add(Node node, int data) {
        if(node == null) {
            return createNode(data);
        }
        if(data < node.data) {
            node.left = add(node.left, data);
        } else {
            node.right = add(node.right, data);
        }
        return node;
    }

    /**
     * Inorder Traversal. For Testing.
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
     * Level Order Traversal. Blindly Apply out BFS logic.
     *
     * @param root Node
     * @return List<Node>
     */
    public static List<Node> levelOrder(Node root) {
        List<Node> queue = new ArrayList<>();
        Set<Node> visited = new HashSet<>();
        List<Node> output = new ArrayList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            Node node = queue.removeFirst();
            if(visited.contains(node)) {
                continue;
            }
            output.add(node);
            visited.add(node);
            if(node.left != null && !visited.contains(node.left)) {
                queue.addLast(node.left);
            }
            if(node.right != null && !visited.contains(node.left)) {
                queue.addLast(node.right);
            }
        }
        return output;
    }

    /**
     * Right View Of Binary Tree.
     * Blindly apply bfs, inorder traversal logic. Modified visited logic completely.
     *
     * @param root Node
     * @return List<Node>
     */
    public static List<Node> rightView(Node root) {
        List<Node> queue = new ArrayList<>();
        Set<Node> visited = new HashSet<>();
        List<Node> output = new ArrayList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node node = queue.removeFirst();
                if (!visited.contains(node)) {
                    output.add(node);
                    // After adding right node to the output.
                    // Mark all the node in that level to visited.
                    // So that it won't be added to output again.
                    visited.addAll(queue);
                }
                // Print only right
                if (node.right != null) {
                    queue.addLast(node.right);
                }
                // If right is not there print left.
                if (node.left != null) {
                    queue.addLast(node.left);
                }
            }
        }
        return output;
    }

    public static Node createNode(int data) {
        Node node = new Node();
        node.left = null;
        node.right = null;
        node.data = data;
        return node;
    }

    public static void main(String []args) {
        // Format of this binary tree. 4 is root.
        // 4 -> 2,7
        // 2 -> 1,3
        // 7 -> 5
        Node root = null;
        root = add(root,4);
        root = add(root,2);
        root = add(root,7);
        root = add(root,1);
        root = add(root,3);
        root = add(root,5);
        inorder(root);
        System.out.println();
        levelOrder(root).forEach(e -> System.out.print(e.data + " "));
        System.out.println();
        rightView(root).forEach(e -> System.out.print(e.data + " "));
    }
}
