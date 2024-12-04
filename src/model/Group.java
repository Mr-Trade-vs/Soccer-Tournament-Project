package model;

public class Group {

    private Team[] group;

    /**
     * Constructor for the Group class.
     * 
     * @param group The array of teams in the group.
     */
    public Group(Team[] group) {
        this.group = group;
    }

    /**
     * Gets the array of teams in the group.
     * 
     * @return The array of teams.
     */
    public Team[] getGroup() {
        return group;
    }
}
