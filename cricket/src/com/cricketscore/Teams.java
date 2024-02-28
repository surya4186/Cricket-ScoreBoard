package com.cricketscore;

import java.util.ArrayList;
import java.util.HashMap;

public class Teams {

	static HashMap<Integer, ArrayList<String>> teamOneScores = new HashMap<Integer, ArrayList<String>>();
	static HashMap<Integer, ArrayList<String>> teamTwoScores = new HashMap<Integer, ArrayList<String>>();
	static HashMap<Integer, Player> teamOnePlayerDetails = new HashMap<Integer, Player>();
	static HashMap<Integer, Player> teamTwoPlayerDetails = new HashMap<Integer, Player>();
	static int[] teamsScores = { 0, 0, 0, 0 };

	public static void teamChoice(int firstChoice) {
		int i = 1;
		System.out.println("Team Choice : ");
		if (firstChoice != 1) {
			System.out.println(i + " India");
			i++;
		}
		if (firstChoice != 2) {
			System.out.println(i + " England");
			i++;
		}
		if (firstChoice != 3) {
			System.out.println(i + " Bangaladesh");
			i++;
		}
		if (firstChoice != 4) {
			System.out.println(i + " Afganishtan");
			i++;
		}
		if (firstChoice != 5) {
			System.out.println(i + " Pakistan");
			i++;
		}
		if (firstChoice != 6) {
			System.out.println(i + " SriLanKa");
			i++;
		}
	}

	public static String[] teamIndiaEleven() {
		String[] indeleven = { "Rohit", "Kohli", "Rahul", "Surya", "Pant", "Hardik", "Jadeja", "Bhuvi", "Shami",
				"Bumrah", "Chahal" };
		String[] teamCap = { "Rohit", "India" };
		team(indeleven, teamCap);
		return teamCap;
	}

	public static String[] teamSrilankaEleven() {
		String[] slElven = { "P.Nisanka", "K.Mendis", "C.Asalanka", "D.Gunathilaka", "B.Rajapaksa", "D.Sanaka",
				"W.Hasaranga", "C.Karunaratne", "M.Theeksana", "A.Fernando", "D.Madushana" };
		String[] teamCap = { "D.Sanaka", "Srilanka" };
		team(slElven, teamCap);
		return teamCap;
	}

	public static String[] teamBangaladeshEleven() {
		String[] banEleven = { "S.Rahman", "M.Hossain", "Shakib", "M.Rahim", "Mahmudullah", "M.Hassan", "A.Hossain",
				"M.Hasan", "T.Ahmad", "E.Hossain", "M.Rahman" };
		String[] teamCap = { "Shakib", "Bangaladesh" };
		team(banEleven, teamCap);
		return teamCap;
	}

	public static String[] teamAfganistanEleven() {
		String[] afgEleven = { "H.Zazai", "R.Gurbaz", "I.Zardan", "N.Zadran", "M.Nabi", "K.Janat", "Rashid",
				"A.Omarzai", "M.U.Rahman", "F.Malik", "F.Farooqi" };
		String[] teamCap = { "M.Nabi", "Afganistan" };
		team(afgEleven, teamCap);
		return teamCap;
	}

	public static String[] teamPakistanEleven() {
		String[] pakEleven = { "M.Rizwan", "B.Azam", "F.Zaman", "I.Ahmad", "K.Shah", "A.Ali", "M.Nawaz", "S.Khan",
				"H.Rauf", "M.Hasnain", "N.Shah" };
		String[] teamCap = { "B.Azam", "Pakistan" };
		team(pakEleven, teamCap);
		return teamCap;
	}

	public static String[] teamEnglandEleven() {
		String[] engEleven = { "Jos Buttler", "Moeen Ali", "Jonny Bairstow", "Ben Stokes", "Sam Curran", "Livingstone",
				"Adil Rashid", "David Willey", "Mark Wood,", "Woakes", "Gus Atkinson" };
		String[] teamCap = { "Jos Buttler", "England" };
		team(engEleven, teamCap);
		return teamCap;
	}

	static int teamCount = 0;

	public static void team(String[] playingeEeven, String[] teamCap) {
		Player pc;
		for (int i = 0; i < playingeEeven.length; i++) {
			pc = new Player();
			pc.setId(i + 1);
			pc.setName(playingeEeven[i]);
			pc.setTeam(teamCap[1]);
			if (teamCap[0].equals(playingeEeven[i])) {
				pc.setCaptain("C");
				pc.setTeam(teamCap[1]);
			}
			pc.setBallfaced(0);
			pc.setBatScore(0);
			pc.setBowlscore(0);
			pc.setFours(0);
			pc.setOversbowled(0);
			pc.setSixes(0);
			pc.setStrikeRate(0.0F);
			pc.setWicketTaken(0);
			if (teamCount % 2 == 0) {
				teamOnePlayerDetails.put(pc.getId(), pc);
			} else {
				teamTwoPlayerDetails.put(pc.getId(), pc);
			}
		}

		teamCount++;
		if (teamCount == 2) {
			teamCount = 0;
		}
	}

	public static void scoreBoard() {

		System.out.println("\n***********************SCORE BOARD***********************\n");

		System.out.format("%-20s|%-10s|%-8s|%-6s|%-8s|\n", "PLAYER", "R(B)", "4s", "6s", "SR");
		for (int i = 0; i < teamOnePlayerDetails.size(); i++) {
			System.out.println();
			System.out.format("%-20s|%-10s|%-8s|%-6s|%.2f|\n", teamOnePlayerDetails.get(i + 1).getName(),
					teamOnePlayerDetails.get(i + 1).getBatScore() + "(" + teamOnePlayerDetails.get(i + 1).getBallfaced()
							+ ")",
					teamOnePlayerDetails.get(i + 1).getFours(), teamOnePlayerDetails.get(i + 1).getSixes(),
					teamOnePlayerDetails.get(i + 1).getStrikeRate());
		}
		System.out.println("\n");
		for (int i = 0; i < teamOneScores.size(); i++) {
			System.out.println("over " + (i + 1) + " " + teamOneScores.get(i + 1));
		}

		System.out.println();
		System.out.format("%-20s|%-8s|%-8s|\n", "BOWLER", "RunGiven", "Wickets");
		for (int i = 6; i < teamTwoPlayerDetails.size(); i++) {
			System.out.println();
			System.out.format("%-20s|%-8s|%-8s|\n", teamTwoPlayerDetails.get(i + 1).getName(),
					teamTwoPlayerDetails.get(i + 1).getBowlscore(), teamTwoPlayerDetails.get(i + 1).getWicketTaken());
		}
		System.out.println();

		System.out
				.println("\n" + teamOnePlayerDetails.get(1).getTeam() + "  " + teamsScores[0] + " - " + teamsScores[1]);

		System.out.println("\n");
		System.out.format("%-20s|%-10s|%-8s|%-6s|%-8s|\n", "PLAYER", "R(B)", "4s", "6s", "SR");
		for (int i = 0; i < teamTwoPlayerDetails.size(); i++) {
			System.out.println();
			System.out.format("%-20s|%-10s|%-8s|%-6s|%.2f|\n", teamTwoPlayerDetails.get(i + 1).getName(),
					teamTwoPlayerDetails.get(i + 1).getBatScore() + "(" + teamTwoPlayerDetails.get(i + 1).getBallfaced()
							+ ")",
					teamTwoPlayerDetails.get(i + 1).getFours(), teamTwoPlayerDetails.get(i + 1).getSixes(),
					teamTwoPlayerDetails.get(i + 1).getStrikeRate());
		}
		System.out.println("\n");
		for (int i = 0; i < teamTwoScores.size(); i++) {
			System.out.println("over " + (i + 1) + " " + teamTwoScores.get(i + 1));
		}

		System.out.println();
		System.out.format("%-20s|%-8s|%-8s|\n", "BOWLER", "RunGiven", "Wickets");
		for (int i = 6; i < teamOnePlayerDetails.size(); i++) {
			System.out.println();
			System.out.format("%-20s|%-8s|%-8s|\n", teamOnePlayerDetails.get(i + 1).getName(),
					teamOnePlayerDetails.get(i + 1).getBowlscore(), teamOnePlayerDetails.get(i + 1).getWicketTaken());
		}
		System.out.println();

		System.out.println("\n" + teamTwoPlayerDetails.get(1).getTeam() + "  " + teamsScores[2] + " - " + teamsScores[3]
				+ "                     " + teamOnePlayerDetails.get(1).getTeam() + "  " + teamsScores[0] + " - "
				+ teamsScores[1]);

		System.out.println("\n");
		if (teamsScores[0] > teamsScores[2]) {
			System.out.println("****************** " + teamOnePlayerDetails.get(1).getTeam()
					+ " Won the Match ******************");
		} else {
			System.out.println("****************** " + teamTwoPlayerDetails.get(1).getTeam()
					+ " Won the Match ******************");
		}
	}

}
