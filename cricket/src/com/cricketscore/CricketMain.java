package com.cricketscore;

import java.util.Arrays;
import java.util.Scanner;

public class CricketMain{

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		String[] teamOneCaptain = { "", "" };
		String[] teamTwoCaptain = { "", "" };
		String[] toss = { "Heads", "Tails" };
		String[] choice = { "Bat", "Bowl" };
		int bat = 0, overs = 0;
		boolean teamSelection = true;
		boolean tossing = true;
		boolean overSelection = true;
		while (overSelection) {
			System.out.println("Select Overs \n1.ten \n2.twenty \n3.YourChoice");
			int value = scan.nextInt();
			if (value == 3) {
				System.out.println("Enter the number of overs : ");
				overs = scan.nextInt();
				System.out.println();
				overSelection = false;
			} else if (value == 1 || value == 2) {
				System.out.println();
				overs = GamePlay.overs(value);
				overSelection = false;
			} else {
				System.out.println("\nPlease select correct option\n");
			}
		}

		while (teamSelection) {
			Teams.teamChoice(-1);
			int team1Choice = scan.nextInt();
			System.out.println();
			Teams.teamChoice(team1Choice);
			int team2Choice = scan.nextInt();
			if (team2Choice == team1Choice) {
				team2Choice++;
			}else if (team1Choice<team2Choice) {
				team2Choice++;
			}

			System.out.println();

			teamOneCaptain = GamePlay.teamSelection(team1Choice);
			System.out.print(" VS ");
			teamTwoCaptain = GamePlay.teamSelection(team2Choice);
			System.out.println();
			teamSelection = false;
		}

		while (tossing) {
			String[] captains = { teamOneCaptain[0], teamTwoCaptain[0] };
			String cap = GamePlay.getRandom(captains);

			System.out.println("\n" + cap + " is ready to choose");

			if (cap.equals(teamOneCaptain[0])) {

				System.out.println("\nToss Choice : \nH-Heads \nT-Tails");
				String selectedToss = "" + scan.next().charAt(0);
				if (selectedToss.equalsIgnoreCase("h") || selectedToss.equalsIgnoreCase("t")) {
					String tossUpdate = GamePlay.getRandom(toss);
					if (selectedToss.equals("" + tossUpdate.charAt(0))) {
						System.out.println("\n" + teamOneCaptain[0] + " own the toss");
						System.out.println("\nSelect \n1.Bating \n2.Bowling");
						int playChoice = scan.nextInt();
						bat = playChoice;
						String play = GamePlay.playingChoice(playChoice);
						System.out.println("\n" + teamOneCaptain[1] + " own the toss and selected to " + play + "\n");
						tossing = false;
						GamePlay.matchStart(overs, bat);
					} else {
						int[] batBowl = { 1, 2 };
						int playChoice = GamePlay.getRandom(batBowl);
						if (playChoice == 1) {
							bat = 2;
						} else {
							bat = 1;
						}
						String play = GamePlay.playingChoice(playChoice);
						System.out.println("\n" + teamTwoCaptain[1] + " own the toss and selected to " + play + "\n");
						tossing = false;
						GamePlay.matchStart(overs, bat);
					}

				} else {
					System.out.println("\nYou entered Wrong Option. " + "Please Choose Correction...\n");
				}
			} else {
				String selectedToss = GamePlay.getRandom(choice);
				String tossUpdate = GamePlay.getRandom(toss);
				if (selectedToss.equals("" + tossUpdate.charAt(0))) {
					int[] batBowl = { 1, 2 };
					int playChoice = GamePlay.getRandom(batBowl);
					if (playChoice == 1) {
						bat = 2;
					} else {
						bat = 1;
					}
					String play = GamePlay.playingChoice(playChoice);
					System.out.println("\n" + teamTwoCaptain[1] + " own the toss and selected to " + play);
					tossing = false;
					GamePlay.matchStart(overs, bat);
				} else {
					System.out.println("\n" + teamOneCaptain[0] + " own the toss");
					System.out.println("\nSelect \n1.Bating \n2.Bowling");
					int playChoice = scan.nextInt();
					bat = playChoice;
					String play = GamePlay.playingChoice(playChoice);
					System.out.println("\n" + teamOneCaptain[1] + " own the toss and selected to " + play);
					tossing = false;
					GamePlay.matchStart(overs, bat);
				}
			}
		}
	}
}
