package com.ds.basics.linkedlist;

/**
 * Code No: 141,142 - Linked List Cycle
 *
 * @author Karthikeyan
 */
public class LinkedListCycle {

    public static class Node {
        int data;
        Node next = null;
    }

    public static boolean hasCycle(Node root) {
        Node firstPointer = root;
        Node secondPointer = root;
        while(firstPointer != null && secondPointer != null && secondPointer.next != null) {
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next.next;
            if(firstPointer == secondPointer) {
                return true;
            }
        }
        return false;
    }

    public static int detectCyclePos(Node root) {
        Node firstPointer = root;
        Node secondPointer = root;
        boolean hasCycle = false;
        while(firstPointer != null && secondPointer != null && secondPointer.next != null) {
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next.next;
            if(firstPointer == secondPointer) {
                hasCycle = true;
                break;
            }
        }
        if(!hasCycle) {
            return -1;
        } else {
            firstPointer = root;
            while (firstPointer != secondPointer) {
                firstPointer = firstPointer.next;
                secondPointer = secondPointer.next;
            }
        }
        return firstPointer.data;
    }

    public static Node add(Node root, int data) {
        Node node = new Node();
        node.data = data;
        node.next = null;
        if(root == null) {
            root = node;
        } else {
            Node lastnode = root;
            Node insertNode = null;
            while(lastnode != null) {
                insertNode = lastnode; // Track the previous node for insert.
                lastnode = lastnode.next;
            }
            insertNode.next = node;
        }
        return root;
    }

    public static Node returnLast(Node root) {
        Node lastnode = root;
        while(lastnode.next != null) {
            lastnode = lastnode.next;
        }
        return lastnode;
    }

    public static void main(String []args) {
        Node root = null;
        root = add(root,10);
        root = add(root,12);
        root = add(root,15);
        root = add(root,11);
        System.out.println(hasCycle(root));
        Node lastNode = returnLast(root);
        lastNode.next = root.next.next;
        System.out.println(hasCycle(root));
        System.out.println(detectCyclePos(root));
    }
}
