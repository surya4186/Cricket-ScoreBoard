package com.cricketscore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class GamePlay extends Teams {

	public static String getRandom(String[] array) {
		int rnd = new Random().nextInt(array.length);
		return array[rnd];
	}

	public static int getRandom(int[] array) {
		int rnd = new Random().nextInt(array.length);
		return array[rnd];
	}

	static int  value=0;

	public static String[] teamSelection(int num) {
		value = num;
		switch (num) {
		case 1:
			System.out.print("Team India");
			return teamIndiaEleven();
		case 2:
			System.out.print("Team England");
			return teamEnglandEleven();
		case 3:
			System.out.print("Team Bangaladesh");
			return teamBangaladeshEleven();
		case 4:
			System.out.print("Team Afganistan");
			return teamAfganistanEleven();
		case 5:
			System.out.print("Team Pakistan");
			return teamPakistanEleven();
		case 6:
			System.out.print("Team Srilanka");
			return teamSrilankaEleven();

		default:
			return null;
		}
	}

	public static String playingChoice(int num) {
		switch (num) {
		case 1:
			return "Batting First";
		case 2:
			return "Bowling First";
		default:
			String[] str = { "Batting First", "Bowling First" };
			String st = getRandom(str);
			return st;
		}
	}

	public static int overs(int num) {
		switch (num) {
		case 1:

			return 10;
		case 2:

			return 20;
		default:
			int[] over = { 10, 20 };
			int ovr = getRandom(over);
			return ovr;
		}
	}

	public static void matchStart(int over, int bat) {
		int balls = over * 6;
		int innings1 = 1, innings2 = 2;
		HashMap<Integer, Player> batting = new HashMap<Integer, Player>();
		if (bat == 1) {
			play(balls, innings1, teamOnePlayerDetails, teamTwoPlayerDetails);
			play(balls, innings2, teamTwoPlayerDetails, teamOnePlayerDetails);
		} else {
			play(balls, innings1, teamTwoPlayerDetails, teamOnePlayerDetails);
			play(balls, innings2, teamOnePlayerDetails, teamTwoPlayerDetails);
			batting = teamTwoPlayerDetails;
			teamTwoPlayerDetails = teamOnePlayerDetails;
			teamOnePlayerDetails = batting;
		}
		scoreBoard();
	}

	public static void play(int balls, int innings, HashMap<Integer, Player> teamBat,
			HashMap<Integer, Player> teamBowl) {

		ArrayList<String> sixballs = new ArrayList<String>();
		int ballCount = 1, temp = 2, batsman = 2, totalScore = 0, batScore = 0, rungiven = 0, overCount = 1,
				wicketCount = 0;
		int ballsFaced = 0, foursCount = 0, sixCount = 0, wicketTake = 0;
		float strikerate = 0f;
		String run;
		String[] bowlOne = { "0", "1", "2", "3", "4", "6", "W", "wd", "Nb" };
		String[] bowlTwo = { "0", "1", "2", "3", "4", "6", "wd", "Nb" };

		int bowler = 7;
		int[] striker = { 1, 2 };

		while (ballCount <= balls && wicketCount < 11) {

			if (innings == 2) {
				if (teamsScores[0] < teamsScores[2]) {
					if (teamBat.get(striker[0]).getBallfaced() > 0) {
						strikerate = ((teamBat.get(striker[0]).getBatScore()) * 100)
								/ (teamBat.get(striker[0]).getBallfaced());
						teamBat.get(striker[0]).setStrikeRate(strikerate);
					}
					if (teamBat.get(striker[1]).getBallfaced() > 0) {
						strikerate = ((teamBat.get(striker[1]).getBatScore()) * 100)
								/ (teamBat.get(striker[1]).getBallfaced());
						teamBat.get(striker[1]).setStrikeRate(strikerate);
					}
					// sixballs.add(teamBowl.get(bowler).getName());
					teamTwoScores.put(overCount, sixballs);
					return;
				}
				teamsScores[2] = totalScore;
				teamsScores[3] = wicketCount;
			}
			if (sixballs.size() != 0) {
				if (sixballs.get(sixballs.size() - 1).equals("Nb")) {
					run = getRandom(bowlTwo);
				} else {
					run = getRandom(bowlOne);
				}
			} else {
				run = getRandom(bowlOne);
			}

			if ("0".equals(run)) {
				sixballs.add(run);
				ballsFaced = teamBat.get(striker[0]).getBallfaced() + 1;
				teamBat.get(striker[0]).setBallfaced(ballsFaced);
				if (ballCount % 6 == 0) {
					temp = striker[0];
					striker[0] = striker[1];
					striker[1] = temp;
				}
			} else if ("1".equals(run)) {
				sixballs.add(run);
				totalScore += 1;
				batScore = teamBat.get(striker[0]).getBatScore() + 1;
				teamBat.get(striker[0]).setBatScore(batScore);
				ballsFaced = teamBat.get(striker[0]).getBallfaced() + 1;
				teamBat.get(striker[0]).setBallfaced(ballsFaced);
				rungiven = teamBowl.get(bowler).getBowlscore() + 1;
				teamBowl.get(bowler).setBowlscore(rungiven);
				if (ballCount % 6 != 0) {
					temp = striker[0];
					striker[0] = striker[1];
					striker[1] = temp;
				}
			} else if ("2".equals(run)) {
				totalScore += 2;
				sixballs.add(run);
				batScore = teamBat.get(striker[0]).getBatScore() + 2;
				teamBat.get(striker[0]).setBatScore(batScore);
				ballsFaced = teamBat.get(striker[0]).getBallfaced() + 1;
				teamBat.get(striker[0]).setBallfaced(ballsFaced);
				rungiven = teamBowl.get(bowler).getBowlscore() + 2;
				teamBowl.get(bowler).setBowlscore(rungiven);
				if (ballCount % 6 == 0) {
					temp = striker[0];
					striker[0] = striker[1];
					striker[1] = temp;
				}
			} else if ("3".equals(run)) {
				totalScore += 3;
				sixballs.add(run);
				batScore = teamBat.get(striker[0]).getBatScore() + 3;
				teamBat.get(striker[0]).setBatScore(batScore);
				ballsFaced = teamBat.get(striker[0]).getBallfaced() + 1;
				teamBat.get(striker[0]).setBallfaced(ballsFaced);
				rungiven = teamBowl.get(bowler).getBowlscore() + 3;
				teamBowl.get(bowler).setBowlscore(rungiven);
				if (ballCount % 6 != 0) {
					temp = striker[0];
					striker[0] = striker[1];
					striker[1] = temp;
				}
			} else if ("4".equals(run)) {
				totalScore += 4;
				sixballs.add(run);
				batScore = teamBat.get(striker[0]).getBatScore() + 4;
				teamBat.get(striker[0]).setBatScore(batScore);
				ballsFaced = teamBat.get(striker[0]).getBallfaced() + 1;
				teamBat.get(striker[0]).setBallfaced(ballsFaced);
				rungiven = teamBowl.get(bowler).getBowlscore() + 4;
				teamBowl.get(bowler).setBowlscore(rungiven);
				foursCount = teamBat.get(striker[0]).getFours() + 1;
				teamBat.get(striker[0]).setFours(foursCount);
				if (ballCount % 6 == 0) {
					temp = striker[0];
					striker[0] = striker[1];
					striker[1] = temp;
				}
			} else if ("6".equals(run)) {
				totalScore += 6;
				sixballs.add(run);
				batScore = teamBat.get(striker[0]).getBatScore() + 6;
				teamBat.get(striker[0]).setBatScore(batScore);
				ballsFaced = teamBat.get(striker[0]).getBallfaced() + 1;
				teamBat.get(striker[0]).setBallfaced(ballsFaced);
				rungiven = teamBowl.get(bowler).getBowlscore() + 6;
				teamBowl.get(bowler).setBowlscore(rungiven);
				sixCount = teamBat.get(striker[0]).getSixes() + 1;
				teamBat.get(striker[0]).setSixes(sixCount);
				if (ballCount % 6 == 0) {
					temp = striker[0];
					striker[0] = striker[1];
					striker[1] = temp;
				}
			} else if ("wd".equals(run)) {
				totalScore += 1;
				sixballs.add(run);
				rungiven = teamBowl.get(bowler).getBowlscore() + 1;
				teamBowl.get(bowler).setBowlscore(rungiven);
			} else if ("Nb".equals(run)) {
				totalScore += 1;
				sixballs.add(run);
				rungiven = teamBowl.get(bowler).getBowlscore() + 1;
				teamBowl.get(bowler).setBowlscore(rungiven);
			} else if ("W".equals(run)) {
				sixballs.add(run);
				ballsFaced = teamBat.get(striker[0]).getBallfaced() + 1;
				teamBat.get(striker[0]).setBallfaced(ballsFaced);
				strikerate = (((float) teamBat.get(striker[0]).getBatScore()) * 100)
						/ ((float) teamBat.get(striker[0]).getBallfaced());
				teamBat.get(striker[0]).setStrikeRate(strikerate);
				wicketTake = teamBowl.get(bowler).getWicketTaken() + 1;
				teamBowl.get(bowler).setWicketTaken(wicketTake);
				batsman += 1;
				striker[0] = batsman;
				wicketCount += 1;
				if (innings == 1 && (ballCount == balls || wicketCount < 11)) {
					teamsScores[0] = totalScore;
					teamsScores[1] = wicketCount;
				}
				if (innings == 2 && (ballCount == balls || wicketCount < 11)) {
					teamsScores[2] = totalScore;
					teamsScores[3] = wicketCount;
				}
				if (wicketCount == 10) {
					// sixballs.add(teamBowl.get(bowler).getName());
					if (innings == 1) {
						teamOneScores.put(overCount, sixballs);
					} else {
						teamTwoScores.put(overCount, sixballs);
					}
					return;
				}
			}
			if (!"Nb".equals(run) && !"wd".equals(run)) {
				if (ballCount % 6 == 0) {
					// sixballs.add(teamBowl.get(bowler).getName());
					if (innings == 1) {
						teamOneScores.put(overCount, sixballs);
					} else {
						teamTwoScores.put(overCount, sixballs);
					}
					overCount++;
					sixballs = new ArrayList<String>();
					bowler += 1;
					if (bowler == 12) {
						bowler = 7;
					}
				}
			}

			if (innings == 1 && (ballCount == balls || wicketCount < 11)) {
				teamsScores[0] = totalScore;
				teamsScores[1] = wicketCount;
			}

			if (ballCount == balls) {

				if (teamBat.get(striker[0]).getBallfaced() > 0) {
					strikerate = (((float) teamBat.get(striker[0]).getBatScore()) * 100)
							/ ((float) teamBat.get(striker[0]).getBallfaced());
					teamBat.get(striker[0]).setStrikeRate(strikerate);
				}
				if (teamBat.get(striker[1]).getBallfaced() > 0) {
					strikerate = ((teamBat.get(striker[1]).getBatScore()) * 100)
							/ (teamBat.get(striker[1]).getBallfaced());
					teamBat.get(striker[1]).setStrikeRate(strikerate);
				}
			}
			if (!"Nb".equals(run) && !"wd".equals(run)) {
				ballCount++;
			}
		}
	}

}
