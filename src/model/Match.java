package model;

import java.util.List;

/**
* The Match class represents a football match between two teams, including the result and date of the match.
*/
public class Match {

    private Team teamA;
    private Team teamB;
    private int resultFirstTeam;
    private int resultSecondTeam;
    private String dateMatch;
    private List<Referee> referees;

    /**
    * Constructs a new Match with the specified teams, result, and date.
    * 
    * @param teamA The first team in the match.
    * @param teamB The second team in the match.
    * @param dateMatch The date the match is scheduled or played on.
    */

    public Match(Team teamA, Team teamB, String dateMatch) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.dateMatch = dateMatch;
    }

    /**
    * Retrieves the first team in the match.
    * 
    * @return The first team.
    */
    public Team getTeamA() {
        return teamA;
    }

    /**
    * Sets the first team in the match.
    * 
    * @param teamA The first team to set.
    */
    public void setTeamA(Team teamA) {
        this.teamA = teamA;
    }

    /**
    * Retrieves the second team in the match.
    * 
    * @return The second team.
    */
    public Team getTeamB() {
        return teamB;
    }

    /**
    * Sets the second team in the match.
    * 
    * @param teamB The second team to set.
    */
    public void setTeamB(Team teamB) {
        this.teamB = teamB;
    }

    public int getResultFirstTeam() {
        return resultFirstTeam;
    }

    public void setResultFirstTeam(int resultFirstTeam) {
        this.resultFirstTeam = resultFirstTeam;
    }

    public int getResultSecondTeam() {
        return resultSecondTeam;
    }

    public void setResultSecondTeam(int resultSecondTeam) {
        this.resultSecondTeam = resultSecondTeam;
    }

    /**
    * Retrieves the date of the match.
    * 
    * @return The date of the match.
    */
    public String getDateMatch() {
        return dateMatch;
    }

    /**
    * Sets the date of the match.
    * 
    * @param dateMatch The date to set for the match.
    */
    public void setDateMatch(String dateMatch) {
        this.dateMatch = dateMatch;
    }

    /**
    * Retrieves the list of referees for the team.
    *
    * @return a list of referees of the match
    */
    public List<Referee> getReferees() {
        return referees;
    }

    /**
    * Sets the list of referees of the match
    * 
    * @param referees The list of players assigned to match.
    */
    public void setReferees(List<Referee> referees) {
        this.referees = referees;
    }
}
