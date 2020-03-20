package com.techelevator.handicap_calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HandicapCalculatorDemo {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Golfer golfer1 = new Golfer();
		System.out.println("Please enter your name: ");
		golfer1.setName(input.nextLine());
		System.out.println("Please enter your preferred brand: ");
		golfer1.setPreferredBrand(input.nextLine());
		List <Double> differentialList = new ArrayList <> ();
		boolean isDone = false;
		System.out.println("Enter in 5-20 scores");
		int countScores = 0;
		while (!isDone) {
			System.out.println("Please enter in your score: ");
			int score = Integer.parseInt(input.nextLine());
			System.out.println("Enter the course rating: ");
			double courseRating = Double.parseDouble(input.nextLine());
			System.out.println("Enter the slope of the course: ");
			int slope = Integer.parseInt(input.nextLine());
			double differential = golfer1.calculateDifferential(score, courseRating, slope);
			differentialList.add(differential);
			if (countScores < 20) {
				System.out.println("Type 1 to add another score. Type 2 to recieve handicap");
				boolean entered1Or2 = false;
				while (!entered1Or2) {
					int option = Integer.parseInt(input.nextLine());
					switch (option) {
					case 1:
						countScores++;
						System.out.println("You have " + countScores + " scores.");
						entered1Or2 = true;
						break;
					case 2:
						countScores++;
						entered1Or2 = true;
						isDone = true;
						break;
					default:
						System.out.println("You did not input 1 or 2");
						System.out.println("Type 1 to add another score. Type 2 to recieve handicap");
					}
				}
			}else {
				System.out.println("You have entered in 20 scores");
				isDone = true;
			}
		}
		Collections.sort(differentialList);
		double differentialTotal = 0;
		int differentialCount = 0;
		if (differentialList.size() >= 20) {
			for(int x = 0; x < 10; x++) {
				differentialTotal += differentialList.get(x);
				differentialCount++;
			}
		}else if (differentialList.size() == 19) {
			for(int x = 0; x < 9; x++) {
				differentialTotal += differentialList.get(x);
				differentialCount++;
			}
		}else if (differentialList.size() == 18) {
			for(int x = 0; x < 8; x++) {
				differentialTotal += differentialList.get(x);
				differentialCount++;
			}
		}else if (differentialList.size() == 17) {
			for(int x = 0; x < 7; x++) {
				differentialTotal += differentialList.get(x);
				differentialCount++;
			}
		}else if (differentialList.size() == 16 || differentialList.size() == 15) {
			for(int x = 0; x < 6; x++) {
				differentialTotal += differentialList.get(x);
				differentialCount++;
			}
		}else if (differentialList.size() == 14 || differentialList.size() == 13) {
			for(int x = 0; x < 5; x++) {
				differentialTotal += differentialList.get(x);
				differentialCount++;
			}
		}else if (differentialList.size() == 12 || differentialList.size() == 11) {
			for(int x = 0; x < 4; x++) {
				differentialTotal += differentialList.get(x);
				differentialCount++;
			}
		}else if (differentialList.size() == 10 || differentialList.size() == 9) {
			for(int x = 0; x < 3; x++) {
				differentialTotal += differentialList.get(x);
				differentialCount++;
			}
		}else if (differentialList.size() == 8 || differentialList.size() == 7) {
			for(int x = 0; x < 2; x++) {
				differentialTotal += differentialList.get(x);
				differentialCount++;
			}
		}else if (differentialList.size() == 6 || differentialList.size() == 5) {
			for(int x = 0; x < 1; x++) {
				differentialTotal += differentialList.get(x);
				differentialCount++;
			}
		}
		double differentialAverage = differentialTotal / differentialCount;
		
		if (countScores >= 5) {
			System.out.println(golfer1.getName() + "'s Handicap is: " + String.format("%.2f", golfer1.calculateHandicap(differentialAverage)));
			System.out.println("Thanks " + golfer1.getPreferredBrand() + "!");
		}else {
			System.out.println("You did not input enough scores to calculate a handicap. Please input at least 5 scores.");
		}
		
	}
	
}
