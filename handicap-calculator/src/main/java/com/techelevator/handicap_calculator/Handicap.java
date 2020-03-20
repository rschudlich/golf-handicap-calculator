package com.techelevator.handicap_calculator;

public interface Handicap {
	public double calculateDifferential(int score, double courseRating, int slope);
	public double calculateHandicap(double differentialAverage);
	public double getHandicap();
}
