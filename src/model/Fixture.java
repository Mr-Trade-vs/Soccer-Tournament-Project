package model;

import java.sql.Date;

/**
* The Fixture class represents the schedule of matches for a tournament, organized into two groups
* and including the start date and the list of matches.
*/
public class Fixture {
    private Team[] groupA;
    private Team[] groupB;
    private Date startDate;
    private Match[] matchesFixture;
    
    /**
    * Constructor for creating a new Fixture.
    * 
    * @param groupA Array of teams in Team A.
    * @param groupB Array of teams in Team B.
    * @param startDate The start date of the fixture.
    * @param matchesFixture Array of matches in the fixture.
    */
    public Fixture(Team[] groupA, Team[] groupB, Date startDate, Match[] matchesFixture) {
        this.groupA = groupA;
        this.groupB = groupB;
        this.startDate = startDate;
        this.matchesFixture = matchesFixture;
    }

    /**
    * Returns the teams in Team A.
    * 
    * @return Array of teams in Team A.
    */
    public Team[] getGroupA() {
        return groupA;
    }

    /**
    * Sets the teams for Team A.
    * 
    * @param groupA Array of teams to set for Team A.
    */
    public void setGroupA(Team[] groupA) {
        this.groupA = groupA;
    }

    /**
    * Returns the teams in Team B.
    * 
    * @return Array of teams in Team B.
    */
    public Team[] getGroupB() {
        return groupB;
    }

    /**
    * Sets the teams for Team B.
    * 
    * @param groupB Array of teams to set for Team B.
    */
    public void setGroupB(Team[] groupB) {
        this.groupB = groupB;
    }

    /**
    * Returns the start date of the fixture.
    * 
    * @return The start date of the fixture.
    */
    public Date getStartDate() {
        return startDate;
    }

    /**
    * Sets the start date for the fixture.
    * 
    * @param startDate The date to set as the fixture's start date.
    */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
    * Returns the list of matches in the fixture.
    * 
    * @return Array of Match objects in the fixture.
    */
    public Match[] getMatchesFixture() {
        return matchesFixture;
    }

    /**
    * Sets the list of matches for the fixture.
    * 
    * @param matchesFixture Array of Match objects to set in the fixture.
    */
    public void setMatchesFixture(Match[] matchesFixture) {
        this.matchesFixture = matchesFixture;
    }

}
