package org.hanjia.datastructure.basic.tree;

import java.util.Stack;

public class PostorderTraversal {

	public void postorderTraversalRecursive(BinaryTreeNode root) {
		if (root != null) {
			postorderTraversalRecursive(root.getLeft());
			postorderTraversalRecursive(root.getRight());
			System.out.print(root.getValue() + ",");
		}
	}

	public void postorderTraversalIterative(BinaryTreeNode root) {
		if (root == null)
			return;
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		while (true) {
			if (root != null) {
				stack.push(root);
				root = root.getLeft();
			} else {
				if (stack.isEmpty()) {
					break;
				}

				if (stack.peek().getRight() == null) {
					root = stack.pop();
					System.out.println(root.getValue());
					if (root == stack.peek().getRight()) { // 如果当前节点与堆栈内最上层节点的右节点相同，则可以确定已经处理完左右节点只需打印根节点
						root = stack.pop();
						System.out.println(root.getValue());
					}
				}
			}

			if (!stack.isEmpty()) {
				root = stack.peek().getRight();
			} else {
				root = null;
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

		PostorderTraversal traversal = new PostorderTraversal();
		traversal.postorderTraversalRecursive(root);
		System.out.println();
		traversal.postorderTraversalIterative(root);
	}
}
