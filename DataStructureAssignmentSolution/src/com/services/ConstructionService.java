package com.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author AnubhavChaturvedi
 * @category DataStructureAssignmentSolution
 * @date 2021-10-09
 */

public class ConstructionService {

	private int currentFloorNo;
	private List<Integer> floorsOnNthDay;
	private List<Integer> remainingFloors;

	public void floorsAssemblingProcess(List<Integer> pFloorSizes, int pNoOfFloors) {

		currentFloorNo = pNoOfFloors;
		remainingFloors = new ArrayList<>();

		for (int lDay = 0; lDay < pNoOfFloors; lDay++) {
			floorsOnNthDay = new ArrayList<>();
			int lFloorSize = pFloorSizes.get(lDay);

			// Adding floors to be assembled on the nth day
			if (lFloorSize == currentFloorNo) {
				floorsOnNthDay.add(lFloorSize);
				currentFloorNo--;

				// Checking the remaining number of floors to be assembled
				checkRemainingFloors(remainingFloors, currentFloorNo);
			}

			// Adding smaller size floors temporarily
			if (lFloorSize < currentFloorNo) {
				remainingFloors.add(lFloorSize);
			}

			// Final process for assembling floors
			System.out.println("Day: " + (lDay + 1) + "\n"
					+ floorsOnNthDay.toString().substring(1).replace("]", "").replaceAll(", ", " "));
		}
	}

	private void checkRemainingFloors(List<Integer> pRemainingFloors, int pCurrentFloor) {

		Iterator<Integer> lIterator = pRemainingFloors.iterator();

		while (lIterator.hasNext()) {
			int lRemainingFloor = lIterator.next();

			if (lRemainingFloor == pCurrentFloor) {
				floorsOnNthDay.add(lRemainingFloor);
				this.currentFloorNo--;

				// Recursive call
				checkRemainingFloors(pRemainingFloors, this.currentFloorNo);
			}
		}
	}
}
