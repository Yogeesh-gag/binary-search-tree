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
        // Base case: if the current root is null, create a new node
        if (root == null) {
            root = new Node<>(val);
            return root;
        }

        // If the new value is smaller, insert into the left subtree
        if (root.data.compareTo(val) > 0) {
            root.left = insert(root.left, val);
        }

        // If the new value is larger, insert into the right subtree
        else if (root.data.compareTo(val) < 0) {
            root.right = insert(root.right, val);
        }

        // Return the root (unchanged if equal value — duplicates are not inserted)
        return root;
    }

    // In-order traversal: Left -> Root -> Right (used to print BST in sorted order)
    public void inOrder(Node<E> root) {
        if (root == null) {
            return; // Base case: do nothing for empty node
        }

        inOrder(root.left);                 // Traverse left subtree
        System.out.print(root.data + " ");  // Visit root node
        inOrder(root.right);                // Traverse right subtree
    }

    // Method to count the total number of nodes in the BST
    public int size(Node<E> root) {
        if (root == null) {
            return 0; // No nodes in an empty tree
        }

        // Recursively count nodes in left and right subtrees and add 1 (for current node)
        return size(root.left) + size(root.right) + 1;
    }

    // Method to search for a value in the BST (UC3)
    public boolean search(Node root, E key) {
        if (root == null) {
            return false; // Base case: reached leaf node without finding the key
        }

        // If key is less than current node, search in the left subtree
        if (root.data.compareTo(key) > 0) {
            return search(root.left, key);
        }
        // If key is greater than current node, search in the right subtree
        else if (root.data.compareTo(key) < 0) {
            return search(root.right, key);
        }
        // If equal, key is found
        else {
            return true;
        }
    }

    // Main method to test all functionalities (UC1, UC2, UC3)
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(); // Create a BST with Integer type

        // UC2: Array of values to add into the BST
        int values[] = {56, 30, 70, 22, 40, 60, 95, 11, 3, 16, 65, 63, 67};

        Node<Integer> root = null; // Start with an empty tree

        // Insert each value into the BST
        for (int i = 0; i < values.length; i++) {
            root = bst.insert(root, values[i]);
        }

        // Print BST values using in-order traversal
        System.out.println("Printing the values in the Binary Tree:");
        bst.inOrder(root);

        // Print number of nodes in the tree
        System.out.println("\n\nPrinting how many elements are present in the Binary Tree:");
        System.out.println(bst.size(root));  // Should match values.length

        // Verify if all elements were successfully added
        if (values.length == bst.size(root)) {
            System.out.println("All elements are added successfully in the Binary Tree");
        } else {
            System.out.println("All elements are not added successfully in the Binary Tree");
        }

        // UC3: Search for key 63 in the BST
        if (bst.search(root, 63)) {
            System.out.println("63 element is found in the Binary Tree");
        } else {
            System.out.println("63 element is not found in the Binary Tree");
        }
    }
}
