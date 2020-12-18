package org.hanjia.datastructure.searching;

public class BinarySearchTreeNode {
	private int value;
	private BinarySearchTreeNode left;
	private BinarySearchTreeNode right;

	public BinarySearchTreeNode(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public BinarySearchTreeNode getLeft() {
		return left;
	}

	public void setLeft(BinarySearchTreeNode left) {
		this.left = left;
	}

	public BinarySearchTreeNode getRight() {
		return right;
	}

	public void setRight(BinarySearchTreeNode right) {
		this.right = right;
	}

	public BinarySearchTreeNode find(BinarySearchTreeNode root, int data) {
		if (root == null)
			return null;
		if (data < root.getValue()) {
			return find(root.getLeft(), data);
		} else if (data > root.getValue()) {
			return find(root.getRight(), data);
		} else {
			return root;
		}
	}

	public BinarySearchTreeNode findIterative(BinarySearchTreeNode root, int data) {
		if (root == null)
			return null;
		while (root != null) {
			if (data == root.getValue()) {
				return root;
			} else if (data > root.getValue()) {
				root = root.getRight();
			} else {
				root = root.getLeft();
			}
		}
		return null;
	}

	public BinarySearchTreeNode findMin(BinarySearchTreeNode root) {
		if (root == null) {
			return null;
		} else {
			if (root.getLeft() == null)
				return root;
			else
				return findMin(root.getLeft());
		}
	}

	public BinarySearchTreeNode findMinIterative(BinarySearchTreeNode root) {
		if (root == null)
			return null;
		while (root.getLeft() != null) {
			root = root.getLeft();
		}
		return root;
	}

	public BinarySearchTreeNode findMax(BinarySearchTreeNode root) {
		if (root == null)
			return null;
		else {
			if (root.getRight() == null)
				return root;
			else
				return findMax(root.getRight());
		}
	}

	public BinarySearchTreeNode findMaxIterative(BinarySearchTreeNode root) {
		if (root == null)
			return null;
		while (root.getRight() != null) {
			root = root.getRight();
		}
		return root;
	}

	public BinarySearchTreeNode insert(BinarySearchTreeNode root, int data) {
		if (root == null) {
			root = new BinarySearchTreeNode(data);
			root.setLeft(null);
			root.setRight(null);
		} else {
			if (data < root.getValue())
				root.setLeft(insert(root.getLeft(), data));
			else if (data > root.getValue())
				root.setRight(insert(root.getRight(), data));
		}
		return root;
	}
	
	public BinarySearchTreeNode delete(BinarySearchTreeNode root, int data) {
		BinarySearchTreeNode temp = null;
		if (root == null) {
			System.out.println("The tree is empty");
		} else if (data < root.getValue()) {
			root.left = delete(root.getLeft(), data);
		} else if (data > root.getValue()) {
			root.right = delete(root.getRight(), data);
		} else {
			if (root.getLeft() != null && root.getRight() != null) {
				temp = findMax(root.getLeft());
				root.setValue(temp.getValue());
				root.left = delete(root.getLeft(), root.getValue());
			} else {
				temp = root;
				if (root.getLeft() == null)
					root = root.getRight();
				if (root.getRight() == null)
					root = root.getLeft();
				temp = null;
			}
		}
		return root;
	}

}
