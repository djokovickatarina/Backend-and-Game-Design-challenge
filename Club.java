package football;

import java.util.Arrays;

public class Club {
	
	private String name;
	private int[] playersRatings;
	private double clubRating;
	
	public Club(String name, int[] playersRatings) {
		this.name = name;
		this.playersRatings = playersRatings;
	}
	
	public void calculateClubRating() {
		
		int sum = 0;
		for(int i=0; i<playersRatings.length; i++) {
			sum += playersRatings[i];
		}
		clubRating = sum / playersRatings.length;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int[] getPlayersRatings() {
		return playersRatings;
	}

	public void setPlayersRatings(int[] playersRatings) {
		this.playersRatings = playersRatings;
	}

	public double getClubRating() {
		return clubRating;
	}

	public void setClubRating(double clubRating) {
		this.clubRating = clubRating;
	}

	@Override
	public String toString() {
		return "Club [name=" + name + ", playersRatings=" + Arrays.toString(playersRatings) + ", clubRating="
				+ clubRating + "]";
	}
}