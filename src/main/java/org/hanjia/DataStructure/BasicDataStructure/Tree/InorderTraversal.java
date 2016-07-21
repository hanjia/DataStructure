package org.hanjia.DataStructure.BasicDataStructure.Tree;

import java.util.Stack;

public class InorderTraversal {

	public static void inorderTraversalRecursive(BinaryTreeNode root){
		if(root != null){
			inorderTraversalRecursive(root.left);
			System.out.print(root.value + ",");			
			inorderTraversalRecursive(root.right);
		}
	}
	
	public static void inorderTraversalIterative(BinaryTreeNode root){
		if(root == null) 
			return;
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		
		while(true){
			while(root != null){
				s.push(root);
				root = root.left;
			}
			
			if(s.isEmpty()) 
				break;
			root = s.pop();
			System.out.print(root.value + ",");			
			root = root.right;
		}		
	}
	
	public static void main(String[] args){
		BinaryTreeNode root = new BinaryTreeNode(40);
		BinaryTreeNode n1 = new BinaryTreeNode(35);
        BinaryTreeNode n2 = new BinaryTreeNode(42);
        BinaryTreeNode n3 = new BinaryTreeNode(29);
        BinaryTreeNode n4 = new BinaryTreeNode(37);
        BinaryTreeNode n5 = new BinaryTreeNode(41);
        BinaryTreeNode n6 = new BinaryTreeNode(45);
        BinaryTreeNode n7 = new BinaryTreeNode(23);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n3.left = n6;
        n4.left = n7;
        
        inorderTraversalRecursive(root);
        System.out.println();
        inorderTraversalIterative(root);
	}
}
