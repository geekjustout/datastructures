package com.geek.datastructures.exec;

import com.geek.datastructures.BinaryTree;

public class Test {

	public static void main(String[] args) throws Exception {
		
		BinaryTree binaryTree  = new BinaryTree(1);
		binaryTree.insert(binaryTree.getRoot(), 2);
		binaryTree.insert(binaryTree.getRoot(), 3);
		binaryTree.insert(binaryTree.getRoot(), 4);
		binaryTree.insert(binaryTree.getRoot(), 5);
		binaryTree.preorder(binaryTree.getRoot());
		binaryTree.delete(3);
		binaryTree.inorderTravers(binaryTree.getRoot());
		//System.out.println(binaryTree.search(binaryTree.getRoot(), 4));
		//binaryTree.delete(binaryTree.getRoot(), 2);
		//binaryTree.inorderTravers(binaryTree.getRoot());
	}
}
