package football;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of clubs:");
		int noOfClubs = sc.nextInt();
		if (noOfClubs % 2 != 0) {
			System.out.println("Number of clubs should be even. Can't create pairs.");
			System.exit(0);
		}
		List<Club> clubs = new ArrayList<>();

		int i = 0;
		while (i < noOfClubs) {
			String name;
			String playerRating;
			System.out.println("Enter the number of players");
			int n = sc.nextInt();
			while (n < 18 || n > 30) {
				System.out.println("Incorrect number of players!Enter again the number of players");
				n = sc.nextInt();
			}

			int[] playersRatings = new int[n];
			System.out.println("Enter the club name");
			name = sc.next();
			System.out.println(
					"Enter the players rating(as number) or any other character for the end, for " + name + " club:");
			int j = 0;
			while (j < n) {
				playerRating = sc.next();
				try {
					int playerRatingInt = Integer.parseInt(playerRating);
					playersRatings[j] = playerRatingInt;
				} catch (Exception e) {
					// end of entry reached
					break;
				}
				j++;
			}
			Club clubTmp = new Club(name, playersRatings);
			clubTmp.calculateClubRating();
			clubs.add(clubTmp);
			i++;
		}

		Iterator<Map.Entry<Club, Club>> itr = createMatches(clubs).entrySet().iterator();
		while (itr.hasNext()) {
			Map.Entry<Club, Club> entry = itr.next();
			System.out.println("Matched pair : " + entry.getKey().getName() + " - " + entry.getValue().getName());

		}

		sc.close();
	}

	public static Map<Club, Club> createMatches(List<Club> clubs) {
		Map<Club, Club> clubPairs = new HashMap<>();
		Collections.sort(clubs, (p1, p2) -> p1.getClubRating() > p2.getClubRating() ? 1 : -1);
		for (int i = 0; i < clubs.size(); i += 2) {
			if (i + 1 < clubs.size()) {
				clubPairs.put(clubs.get(i), clubs.get(i + 1));
			} else {
				break;
			}
		}
		return clubPairs;
	}

}
