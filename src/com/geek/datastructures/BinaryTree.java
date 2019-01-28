package com.geek.datastructures;

public class BinaryTree {

	private Node root;

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public BinaryTree(int i) {
		super();
		setRoot(new Node(i));
	}

	public class Node {
		int value;
		Node left;
		Node right;

		public Node(int root) {
			super();
			this.value = root;
			left = null;
			right = null;
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

	}

	public void insert(Node root, int i) {
		this.root = insertRec(root, i);
	}

	private Node insertRec(Node root, int i) {
		if (root == null) {
			Node node = new Node(i);
			return node;
		}
		if (i < root.getValue()) {
			root.left = insertRec(root.left, i);
		} else {
			root.right = insertRec(root.right, i);
		}
		return root;
	}

	public void levelOrderTraversal(Node root) {
		if (root != null) {
			System.out.println(root.getValue());
			levelOrderTraversal(root.left);
			levelOrderTraversal(root.right);
		}
	}

	public boolean search(Node root, int element) {
		boolean found = false;
		found= searchRec(root, element);
		return found;
	}

	private boolean searchRec(Node root, int element) {
		if(root !=null) {
			if((root.getValue() == element)) {
				return true;
			}
			if(element < root.getValue()) {
				return searchRec(root.left, element);
			}else if(element > root.getValue()){
				return searchRec(root.right, element);
			}
		}
		return false;
	}
	
	public void inorderTravers(Node root) {
		if (root == null) {
			return;
		}
		inorderTravers(root.left);
		System.out.println(root.getValue());
		inorderTravers(root.right);
	}
	
	public void preorder(Node root) {
	    if(root !=  null) {
	      System.out.printf("%d ",root.value);
	      preorder(root.left);
	      preorder(root.right);
	    }
	  }
	
	public void postOrder(Node root) {
		if(root !=  null) {
			postOrder(root.left);
			postOrder(root.right);
			//Visit the node by Printing the node data  
			System.out.printf("%d ",root.value);
		}
	}
	 
	public void delete(Integer data) {
		 
        deleteNode(this.root, data);
    }
 
    private Node deleteNode(Node root, Integer data) {
 
        if(root == null) return root;
 
        if(data < root.getValue()) {
            root.setLeft(deleteNode(root.getLeft(), data));
        } else if(data > root.getValue()) {
            root.setRight(deleteNode(root.getRight(), data));
        } else {
            // node with no leaf nodes
            if(root.getLeft() == null && root.getRight() == null) {
                System.out.println("deleting "+data);
                return null;
            } else if(root.getLeft() == null) {
                // node with one node (no left node)
                System.out.println("deleting "+data);
                return root.getRight();
            } else if(root.getRight() == null) {
                // node with one node (no right node)
                System.out.println("deleting "+data);
                return root.getLeft();
            } else {
                // nodes with two nodes
                // search for min number in right sub tree
                Integer minValue = minValue(root.getRight());
                root.setValue(minValue);
                root.setRight(deleteNode(root.getRight(), minValue));
                System.out.println("deleting "+data);
            }
        }
 
        return root;
    }
 
    private Integer minValue(Node node) {
 
        if(node.getLeft() != null) {
            return minValue(node.getLeft());
        }
        return node.getValue();
    }
 
}
