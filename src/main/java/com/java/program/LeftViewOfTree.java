package com.java.program;

public class LeftViewOfTree {
	
	static class Node {
		int data;
		Node left, right;
		public Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
	
	Node root; 
    static int  max_level = 0; 
  
    // recursive function to print left view 
    void leftViewUtil(Node node, int level) 
    { 
        // Base Case 
        if (node == null) 
        	return; 
  
        // If this is the first node of its level 
        if (max_level < level) 
        { 
            System.out.print(" " + node.data); 
            max_level = level; 
        } 
  
        // Recur for left and right subtrees 
        leftViewUtil(node.left, level+1); 
        leftViewUtil(node.right, level+1); 
    } 
  
    // A wrapper over leftViewUtil() 
    void leftView() 
    { 
        leftViewUtil(root, 1); 
    } 
    
	public static void main(String[] args) {
		
		LeftViewOfTree tree_level = new LeftViewOfTree();
        tree_level.root = new Node(1);
        tree_level.root.left = new Node(2);
        tree_level.root.right = new Node(3);
        tree_level.root.left.left = new Node(4);
        tree_level.root.left.right = new Node(5);
 
        System.out.println("Level order traversal of binary tree is - ");
       // tree_level.printLevelOrder();
        tree_level.leftView();

	}

}
