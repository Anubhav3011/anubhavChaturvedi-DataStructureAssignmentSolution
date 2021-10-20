package com.services;

import com.model.Node;

/**
 * @author AnubhavChaturvedi
 * @category DataStructureAssignmentSolution
 * @date 2021-10-09
 */

public class BinaryTree {

	public Node insertLevelOrder(Integer[] pArray, Node pRoot, int pIndex) {
		// Base case for recursion
		if (pIndex < pArray.length && pArray[pIndex] != null) {
			Node lTemp = new Node(pArray[pIndex]);
			pRoot = lTemp;

			// insert left child
			pRoot.left = insertLevelOrder(pArray, pRoot.left, 2 * pIndex + 1);

			// insert right child
			pRoot.right = insertLevelOrder(pArray, pRoot.right, 2 * pIndex + 2);
		}
		return pRoot;
	}

	public void printBinaryTree(Node pRoot, int pLevel) {
		// Base case for recursion
		if (pRoot == null)
			return;

		// Recursive call
		printBinaryTree(pRoot.right, pLevel + 1);

		// Printing branches
		if (pLevel != 0) {
			for (int i = 0; i < pLevel - 1; i++)
				System.out.print("|\t");
			System.out.println("|-------" + pRoot.data);
		} else
			System.out.println(pRoot.data);
		printBinaryTree(pRoot.left, pLevel + 1);
	}
}
