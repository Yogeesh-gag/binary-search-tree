package org.example;

// Generic Binary Search Tree class where E extends Comparable
public class BinarySearchTree<E extends Comparable> {

    // Inner static Node class representing a node in the BST
    static class Node<E extends Comparable> {
        E data;          // Data stored in the node (of generic type E)
        Node left;       // Reference to the left child node
        Node right;      // Reference to the right child node

        // Constructor to initialize the node with data
        Node(E data) {
            this.data = data;
        }
    }

    // Method to insert a value into the BST
    public Node insert(Node<E> root, E val) {
        // Base case: if current root is null, create a new node
        if (root == null) {
            root = new Node<>(val);
            return root;
        }

        // If the new value is smaller, insert in the left subtree
        if (root.data.compareTo(val) > 0) {
            root.left = insert(root.left, val);
        }

        // If the new value is larger, insert in the right subtree
        if (root.data.compareTo(val) < 0) {
            root.right = insert(root.right, val);
        }

        // Return the unchanged root pointer
        return root;
    }

    // In-order traversal: Left -> Root -> Right (prints sorted order for BST)
    public void inOrder(Node<E> root) {
        if (root == null) {
            return; // Base case: do nothing for empty subtree
        }

        inOrder(root.left);              // Visit left subtree
        System.out.print(root.data + " "); // Print current node
        inOrder(root.right);             // Visit right subtree
    }

    public int size(Node<E> root){
        if(root==null){
            return 0;
        }
        return size(root.left)+size(root.right)+1;
    }

    // Main method to test the BST
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(); // Create BST with Integer type

        int values[] = {56,30,70,22,40,60,95,11,3,16,65,63,67}; // UC1: Add values to the BST

        Node<Integer> root = null; // Root node initialized as null

        // Insert values into the BST one by one
        for (int i = 0; i < values.length; i++) {
            root = bst.insert(root, values[i]);
        }

        // Display the tree in sorted order using in-order traversal
        System.out.println("Printing the values in the Binary Tree:");
        bst.inOrder(root);

        System.out.println("Printing out many elements present in the Binary Tree");
        System.out.println(bst.size(root));

        if(values.length== bst.size(root)){
            System.out.println("All elements are added successfully in the Binary Tree");
        }
        else{
            System.out.println("All elements are not added successfully in the Binary Tree");
        }
    }
}
