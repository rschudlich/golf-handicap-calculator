package com.techelevator.handicap_calculator;

public class Golfer implements Handicap {
	private String name;
	private double handicap;
	private String preferredBrand;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPreferredBrand() {
		return preferredBrand;
	}

	public void setPreferredBrand(String preferredBrand) {
		this.preferredBrand = preferredBrand;
	}

	@Override
	public double calculateDifferential(int score, double courseRating, int slope) {
		double differential = ((score - courseRating) * 113) / slope;
		return differential;
	}
	
	@Override
	public double calculateHandicap(double differentialAverage) {
		this.handicap = differentialAverage * 0.96;
		return handicap;
	}

	@Override
	public double getHandicap() {
		return handicap;
	}


}
