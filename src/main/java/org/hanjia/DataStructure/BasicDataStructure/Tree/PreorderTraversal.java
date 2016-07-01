package org.hanjia.DataStructure.BasicDataStructure.Tree;

import java.util.Stack;

public class PreorderTraversal {
	public static void preorderTraversalRecursive(BinaryTreeNode root){
		if(root != null){
			System.out.print(root.value + ",");
			preorderTraversalRecursive(root.left);
			preorderTraversalRecursive(root.right);
		}
	}
	
	public static void preorderTraversalIterative(BinaryTreeNode root){
		if(root == null) return;
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		s.push(root);
		
		while(!s.isEmpty()){
			root = s.pop();
			System.out.print(root.value + ",");
			
			if(root.right != null){
				s.push(root.right);
			}			
			if(root.left != null){
				s.push(root.left);
			}			
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
        
        preorderTraversalRecursive(root);
        System.out.println();
        preorderTraversalIterative(root);
	}
}
