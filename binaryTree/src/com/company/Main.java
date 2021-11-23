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

class BST {
    //root of a binary tree
    Node root;
    //constructor
    public BST() {
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
    // deleting an element
    public void deleteNode(int data) {
        deleteNode(root, data);
    }
    public Node deleteNode(Node root, int data) {
        //return null when root is null, stopping condition
        if (root == null)
            return null;
        //traverse the left subtree
        else if(data < root.data){
            root.left = deleteNode(root.left,data);
        }
        else if(data > root.data){
            root.right = deleteNode(root.right, data);
        }
        //3 cases after finding target node
        else {
            //delete node
            if (root.left != null & root.right != null) {
                int rightMin = findRightMin(root.right);
                root.data = rightMin;
                //System.out.println(rightMin);
                root.right = deleteNode(root.right,rightMin);
                return root;
            }
            //case 2: node has 1 child.
            else if (root.left != null) {
                return root.left;
            }
            else if (root.right != null) {
                return root.right;
            }
            //case 3: node has no child
            else{
                return null;
            }
        }


        return root;
    }
        public int findRightMin (Node current){
            return current.left == null ? current.data : findRightMin(current.left);
        }
    }



public class Main {

    public static void main(String[] args) {
        // write your code here
        BST bt = new BST();
        bt.insert(8);
        bt.insert(6);
        bt.insert(16);
        bt.insert(12);
        bt.insert(14);
        bt.insert(7);
        //bt.preorder();
        bt.deleteNode(16);
        bt.preorder();
    }
}
