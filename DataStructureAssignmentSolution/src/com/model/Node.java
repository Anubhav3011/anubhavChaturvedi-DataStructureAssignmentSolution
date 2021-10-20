package com.model;

/**
 * @author AnubhavChaturvedi
 * @category DataStructureAssignmentSolution
 * @date 2021-10-09
 */

public class Node {
	public int data;
	public Node left, right;

	public Node(int pValue) {
		data = pValue;
		left = right = null;
	}
}
