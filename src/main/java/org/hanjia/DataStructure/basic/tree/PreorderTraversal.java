package org.hanjia.datastructure.basic.tree;

import java.util.Stack;

public class PreorderTraversal {
	public void preorderTraversalRecursive(BinaryTreeNode root) {
		if (root != null) {
			System.out.print(root.getValue() + ",");
			preorderTraversalRecursive(root.getLeft());
			preorderTraversalRecursive(root.getRight());
		}
	}

	public void preorderTraversalIterative(BinaryTreeNode root) {
		if (root == null)
			return;
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		stack.push(root);

		while (!stack.isEmpty()) {
			root = stack.pop();
			System.out.print(root.getValue() + ",");

			if (root.getRight() != null) {
				stack.push(root.getRight());
			}
			if (root.getLeft() != null) {
				stack.push(root.getLeft());
			}
		}
	}

	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(40);
		BinaryTreeNode n1 = new BinaryTreeNode(35);
		BinaryTreeNode n2 = new BinaryTreeNode(42);
		BinaryTreeNode n3 = new BinaryTreeNode(29);
		BinaryTreeNode n4 = new BinaryTreeNode(37);
		BinaryTreeNode n5 = new BinaryTreeNode(41);
		BinaryTreeNode n6 = new BinaryTreeNode(45);
		BinaryTreeNode n7 = new BinaryTreeNode(23);
		root.setLeft(n1);
		root.setRight(n2);
		n1.setLeft(n3);
		n1.setRight(n4);
		n2.setLeft(n5);
		n3.setLeft(n6);
		n4.setLeft(n7);

		PreorderTraversal traversal = new PreorderTraversal();
		traversal.preorderTraversalRecursive(root);
		System.out.println();
		traversal.preorderTraversalIterative(root);
	}
}
