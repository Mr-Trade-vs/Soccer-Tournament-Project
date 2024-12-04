package model;

public class Goal {

    /**
     * Defines the type of goal record: goal scorer or assister.
     */
    public enum GoalRecord {
        GOLEADOR,  // Player who scores the goal
        ASISTIDOR     // Player who assists the goal
    }

    private Player player;
    private int quantity;
    private GoalRecord typeGoal;

    /**
     * Constructor for the Goal class.
     * 
     * @param player The player who scored or assisted the goal.
     * @param quantity The number of goals scored or assisted.
     * @param typeGoal The type of goal record (Goal Scorer or Assister).
     */
    public Goal(Player player, int quantity, GoalRecord typeGoal) {
        this.player = player;
        this.quantity = quantity;
        this.typeGoal = typeGoal;
    }

    /**
     * Gets the player associated with the goal record.
     * 
     * @return The player who scored or assisted the goal.
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Sets the player associated with the goal record.
     * 
     * @param player The player who scored or assisted the goal.
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * Gets the number of goals scored or assisted.
     * 
     * @return The number of goals.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the number of goals scored or assisted.
     * 
     * @param quantity The number of goals to set.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets the type of goal record (Goal Scorer or Assister).
     * 
     * @return The type of goal record.
     */
    public GoalRecord getTypeGoal() {
        return typeGoal;
    }

    /**
     * Sets the type of goal record (Goal Scorer or Assister).
     * 
     * @param typeGoal The type of goal record to set.
     */
    public void setTypeGoal(GoalRecord typeGoal) {
        this.typeGoal = typeGoal;
    }
}