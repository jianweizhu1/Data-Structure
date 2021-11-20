package com.company;


class Node {
    int data;
    Node left;
    Node right;
    Node (int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class binaryTree {
    //root of a binary tree
    Node root;
    //constructor
    public binaryTree() {
        this.root = null;
    }
    public void insert(int data) {
        this.root = insert(root, data);
    }
    public Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        else if (data >= root.data) {
            root.right = insert(root.right,data);
        }
        else {
            root.left = insert(root.left, data);
        }
        return root;
    }

    public boolean search(int data) {
        return search(root,data);
    }

    public boolean search(Node root, int data) {
        if (root == null) {
            return false;
        }
        else if (root.data == data) {
            return true;
        }
        else if (data < root.data) {
            return search(root.left, data);
        }
        else {
            return search(root.right,data);
        }
     }
    public void preorder(){
        preorder(root);
    }

    public void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data + " ");
        preorder(root.left);
        preorder(root.right);

    }


}
public class Main {

    public static void main(String[] args) {
        // write your code here
        binaryTree bt = new binaryTree();
        bt.insert(8);
        bt.insert(6);
        bt.insert(16);
        System.out.println(bt.search(8));
    }
}
