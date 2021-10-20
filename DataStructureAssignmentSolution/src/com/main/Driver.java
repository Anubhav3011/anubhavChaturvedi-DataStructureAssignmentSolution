package com.main;

import java.util.Arrays;
import java.util.Scanner;

import com.model.Node;
import com.services.BinaryTree;
import com.services.ConstructionService;
import com.services.TransactionService;

/**
 * @author AnubhavChaturvedi
 * @category DataStructureAssignmentSolution
 * @date 2021-10-09
 */

public class Driver {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		try {
			Scanner lScanner = new Scanner(System.in);
			int lChoice = -1;

			do {
				System.out.print("\n" + "Please enter the Problem Statement from the following: " + "\n"
						+ "1. Construction Service " + "\n" + "2. Transaction Service (BST) " + "\n"
						+ "\nPress 0 to Exit " + "\n");

				lChoice = Integer.parseInt(lScanner.nextLine());
				switch (lChoice) {

				// Exit the program
				case 0: {
					break;
				}

				// Q1. Construction Service
				case 1: {
					ConstructionService lConstructionService = new ConstructionService();
					System.out.println("\n" + "***** Welcome to Construction Service *****" + "\n");
					int lNoOfFloors = 0;

					System.out.println("Enter the total no of floors in the building: ");
					while (lNoOfFloors <= 0) {
						lNoOfFloors = Integer.parseInt(lScanner.nextLine());
						if (lNoOfFloors <= 0)
							System.out.println("Building floors cannot be negative or zero." + "\n"
									+ "Enter again the total no of floors in the building: ");
					}
					int[] lFloorSizes = new int[lNoOfFloors];

					for (int i = 0; i < lNoOfFloors; i++) {
						System.out.println("Enter the floor size given on day " + (i + 1) + " : ");
						int checkInput = Integer.parseInt(lScanner.nextLine());
						if (checkInput > 0)
							lFloorSizes[i] = checkInput;
						else {
							System.out.println("Floor size cannot be negative or zero." + "\n" + "Enter Floor size "
									+ ((i--) + 1) + " again");
						}
					}

					System.out.println("\n" + "The order of construction is as follows" + "\n");
					lConstructionService.floorsAssemblingProcess(Arrays.stream(lFloorSizes).boxed().toList(),
							lNoOfFloors);
				}
					break;

				// Q2. Transaction Service (BST)
				case 2: {
					TransactionService lTransactionService = new TransactionService();
					System.out.println("\n" + "***** Welcome to Transaction Service (BST) *****" + "\n");

					String lInput = null;
					System.out.println("Enter values for binary tree according to level order: " + "\n"
							+ "[Or you can use test case given in the question]" + "\n\n" + "50 30 60 10 null 55"
							+ "\n\n" + "           50" + "\n" + "           / \\" + "\n" + "          /   \\" + "\n"
							+ "         /     \\" + "\n" + "        /       \\" + "\n" + "       30       60" + "\n"
							+ "      /        /" + "\n" + "     /        /" + "\n" + "    10       55" + "\n\n");
					lInput = lScanner.nextLine();
					String[] lTreeString = lInput.split("\s");
					Integer[] lTreeArray = new Integer[lTreeString.length];
					for (int i = 0; i < lTreeString.length; i++) {
						if (!"null".equalsIgnoreCase(lTreeString[i]))
							lTreeArray[i] = Integer.parseInt(lTreeString[i]);
					}

					Node lRoot = null;
					BinaryTree lBinaryTree = new BinaryTree();
					lRoot = lBinaryTree.insertLevelOrder(lTreeArray, lRoot, 0);
					System.out.println("\n" + "Binary Tree (Horizontal Representation)" + "\n");
					lBinaryTree.printBinaryTree(lRoot, 0);

					lTransactionService.convertBSTToRightSkewedTree(lRoot);
					System.out.println("\n" + "Right Skewed Tree" + "\n");
					lTransactionService.traverseRightSkewedTree(lTransactionService.headNode, "\\");
					System.out.println("\n\n" + "Traversal of Right Skewed Tree" + "\n");
					lTransactionService.traverseRightSkewedTree(lTransactionService.headNode, " ");
					System.out.println("");
				}
					break;

				default:
					System.out.println("Invalid choice. Enter a valid no.");
				}
			} while (lChoice != 0);
			lScanner.close();
		} catch (Exception e) {
			System.out.println("Error- " + e.getMessage());
			e.printStackTrace();
		}
	}
}
