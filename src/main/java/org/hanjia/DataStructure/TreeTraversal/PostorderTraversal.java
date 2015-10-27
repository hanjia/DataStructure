package org.hanjia.DataStructure.TreeTraversal;

import java.util.Stack;

public class PostorderTraversal {

	public static void postorderTraversalRecursive(BinaryTreeNode root){
		if(root != null){
			postorderTraversalRecursive(root.left);
			postorderTraversalRecursive(root.right);
			System.out.print(root.value + ",");
		}
	}
	
	public static void postorderTraversalIterative(BinaryTreeNode root){
		if(root == null) return;
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		while(true){
			if(root != null){ //To go to the far left node and store all the previous nodes
				s.push(root);
				root = root.left;
			}else{
				if(s.isEmpty())	break;
				else{
					if(s.peek().right == null){
						root = s.pop();
						System.out.print(root.value + ",");
						if(root == s.peek().right){
							root = s.pop();
							System.out.print(root.value + ",");
						}
					}
				}	
				
				if (!s.isEmpty()) {
					root = s.peek().right;
				} else {
					root = null;
				}			
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
        
        postorderTraversalRecursive(root);
        System.out.println();
        postorderTraversalIterative(root);
	}
}
