package model;

/**
* The Player class represents a football player with attributes such as
* name, country, dorsal number, and position.
*/
public class Player extends Person{

    /**
    * Enumeration representing the possible positions a player can occupy on the field.
    */
    public enum PositionPlayer {
        Arquero,
        Defensa,
        Volante,
        Delantero
    }

    private String numberDorsal;
    private PositionPlayer PositionPlayer;

    /**
    * Constructor for creating a Player instance.
    * 
    * @param numberDorsal The dorsal (jersey) number assigned to the player.
    * @param PositionPlayer The position that the player occupies on the field.
    */
    public Player(String name, String country, String numberDorsal, PositionPlayer PositionPlayer) {
        super(name, country);
        this.numberDorsal = numberDorsal;
        this.PositionPlayer = PositionPlayer;
    }

    /**
    * Retrieves the dorsal number of the player.
    * 
    * @return The dorsal number.
    */
    public String getNumberDorsal() {
        return numberDorsal;
    }

    /**
    * Sets the dorsal number for the player.
    * 
    * @param numberDorsal The dorsal number to set.
    */
    public void setNumberDorsal(String numberDorsal) {
        this.numberDorsal = numberDorsal;
    }

    /**
    * Retrieves the position of the player.
    * 
    * @return The player's position.
    */
    public PositionPlayer getPositionPlayer() {
        return PositionPlayer;
    }

    /**
    * Sets the position of the player.
    * 
    * @param PositionPlayer The position to set.
    */
    public void setPositionPlayer(PositionPlayer PositionPlayer) {
        this.PositionPlayer = PositionPlayer;
    }
}

