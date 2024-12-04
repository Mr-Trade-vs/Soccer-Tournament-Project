package model;

import java.util.List;
import java.util.ArrayList;

/**
* The Team class represents a football team, including its name, country, players, and technical director.
*/
public class Team {

    private String nameTeam;
    private String countryTeam;
    private List<Player> players;
    private String technicalDirector;
    private int matchesPlayed;
    private int matchesWon;
    private int matchesTied;
    private int matchesLost;
    private int goalsFavor;
    private int goalsAgaint;
    private int points;
    private int numberCards;
    private double ratioWins;

    /**
    * Constructs a new Team with the specified name, country, and technical director.
    * 
    * @param nameTeam The name of the team.
    * @param countryTeam The country the team represents.
    * @param technicalDirector The name of the team's technical director.
    */
    public Team(String nameTeam, String countryTeam, String technicalDirector) {
        this.nameTeam = nameTeam;
        this.countryTeam = countryTeam;
        this.technicalDirector = technicalDirector;
        this.players = new ArrayList<>();
    }

    /**
    * Retrieves the name of the team.
    * 
    * @return The name of the team.
    */
    public String getNameTeam() {
        return nameTeam;
    }

    /**
    * Sets the name of the team.
    * 
    * @param nameTeam The name to set for the team.
    */
    public void setNameTeam(String nameTeam) {
        this.nameTeam = nameTeam;
    }

    /**
    * Retrieves the country of the team.
    * 
    * @return The country represented by the team.
    */
    public String getCountryTeam() {
        return countryTeam;
    }

    /**
    * Sets the country of the team.
    * 
    * @param countryTeam The country to set for the team.
    */
    public void setCountryTeam(String countryTeam) {
        this.countryTeam = countryTeam;
    }

    /**
    * Retrieves the list of players in the team.
    * 
    * @return A list of players in the team.
    */
    public List<Player> getPlayers() {
        return players;
    }

    /**
    * Sets the list of players for the team.
    * 
    * @param players The list of players to assign to the team.
    */
    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    /**
    * Retrieves the technical director of the team.
    * 
    * @return The name of the technical director.
    */
    public String getTechnicalDirector() {
        return technicalDirector;
    }

    /**
    * Sets the technical director for the team.
    * 
    * @param technicalDirector The name of the technical director to set.
    */
    public void setTechnicalDirector(String technicalDirector) {
        this.technicalDirector = technicalDirector;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public int getMatchesWon() {
        return matchesWon;
    }

    public void setMatchesWon(int matchesWon) {
        this.matchesWon = matchesWon;
    }

    public int getMatchesTied() {
        return matchesTied;
    }

    public void setMatchesTied(int matchesTied) {
        this.matchesTied = matchesTied;
    }

    public int getMatchesLost() {
        return matchesLost;
    }

    public void setMatchesLost(int matchesLost) {
        this.matchesLost = matchesLost;
    }

    public int getGoalsFavor() {
        return goalsFavor;
    }

    public void setGoalsFavor(int goalsFavor) {
        this.goalsFavor = goalsFavor;
    }

    public int getGoalsAgaint() {
        return goalsAgaint;
    }

    public void setGoalsAgaint(int goalsAgaint) {
        this.goalsAgaint = goalsAgaint;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getNumberCards() {
        return numberCards;
    }

    public void setNumberCards(int numberCards) {
        this.numberCards = numberCards;
    }

    public double getRatioWins() {
        return ratioWins;
    }

    public void setRatioWins(double ratioWins) {
        this.ratioWins = ratioWins;
    }
}