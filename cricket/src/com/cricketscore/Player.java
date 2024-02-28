package com.cricketscore;

public class Player{
	
	private int id;
	private String name;
	private String team;
	private String captain;
	private int fours;
	private int sixes;
	private float strikeRate;
	private int ballfaced;
	private int oversbowled;
	private int wickettaken;
	private int batscore;
	private int bowlscore;
	private int teamscore;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getCaptain() {
		return captain;
	}
	public void setCaptain(String captain) {
		this.captain = captain;
	}
	public int getFours() {
		return fours;
	}
	public void setFours(int fours) {
		this.fours = fours;
	}
	public int getSixes() {
		return sixes;
	}
	public void setSixes(int sixes) {
		this.sixes = sixes;
	}
	public float getStrikeRate() {
		return strikeRate;
	}
	public void setStrikeRate(float strikeRate) {
		this.strikeRate = strikeRate;
	}
	public int getBallfaced() {
		return ballfaced;
	}
	public void setBallfaced(int ballfaced) {
		this.ballfaced = ballfaced;
	}
	public int getOversbowled() {
		return oversbowled;
	}
	public void setOversbowled(int oversbowled) {
		this.oversbowled = oversbowled;
	}
	public int getWicketTaken() {
		return wickettaken;
	}
	public void setWicketTaken(int wickettaken) {
		this.wickettaken = wickettaken;
	}
	public int getBatScore() {
		return batscore;
	}
	public void setBatScore(int batscore) {
		this.batscore = batscore;
	}
	public int getBowlscore() {
		return bowlscore;
	}
	public void setBowlscore(int bowlscore) {
		this.bowlscore = bowlscore;
	}
	public int getScore() {
		return teamscore;
	}
	public void setScore(int teamscore) {
		this.teamscore = teamscore;
	}

}
