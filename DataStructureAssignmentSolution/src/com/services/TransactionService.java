package com.services;

import com.model.Node;

/**
 * @author AnubhavChaturvedi
 * @category DataStructureAssignmentSolution
 * @date 2021-10-09
 */

public class TransactionService {

	private Node prevNode = null;
	public Node headNode = null;
	private static String whitespace = "";

	public void convertBSTToRightSkewedTree(Node pRoot) {

		// Base condition for recursion
		if (pRoot == null) {
			return;
		}

		// Recursion for left end of BST
		convertBSTToRightSkewedTree(pRoot.left);

		Node rightNode = pRoot.right;

		// Checking whether root node of skewed tree is defined or not
		if (headNode == null) {
			headNode = pRoot;
			pRoot.left = null;
			prevNode = pRoot;
		} else {
			prevNode.right = pRoot;
			pRoot.left = null;
			prevNode = pRoot;
		}

		// Recursion for right end of BST
		convertBSTToRightSkewedTree(rightNode);

	}

	// Traversal of right skewed tree
	public void traverseRightSkewedTree(Node pRoot, String delimiter) {

		// Base condition for recursion
		if (pRoot == null) {
			return;
		}
		if (delimiter.indexOf("\\") != -1) {
			System.out.print(whitespace + pRoot.data);
			whitespace += " ";
			if (pRoot.right != null)
				System.out.print("\n" + whitespace + delimiter + "\n");
		} else
			System.out.print(pRoot.data + delimiter);
		traverseRightSkewedTree(pRoot.right, delimiter);
	}
}
