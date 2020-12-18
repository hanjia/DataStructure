package org.hanjia.datastructure.basic.tree;

import java.util.Stack;

public class InorderTraversal {

	public void inorderTraversalRecursive(BinaryTreeNode root) {
		if (root != null) {
			inorderTraversalRecursive(root.getLeft());
			System.out.print(root.getValue() + ",");
			inorderTraversalRecursive(root.getRight());
		}
	}

	public void inorderTraversalIterative(BinaryTreeNode root) {
		if (root == null)
			return;
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();

		while (true) {
			while (root != null) {
				s.push(root);
				root = root.getLeft();
			}

			if (s.isEmpty())
				break;
			root = s.pop();
			System.out.print(root.getValue() + ",");
			root = root.getRight();
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

		InorderTraversal traversal = new InorderTraversal();
		traversal.inorderTraversalRecursive(root);
		System.out.println();
		traversal.inorderTraversalIterative(root);
	}
}
