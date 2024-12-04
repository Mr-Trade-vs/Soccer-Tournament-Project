package model;

import java.util.List;

/**
 * Represents a card (yellow or red) that a player receives during a match.
 * The card contains information about the player who received it, 
 * the number of cards assigned, and the referees who assigned the card.
 */
public class Card {

    /**
     * Types of cards a player can receive.
     */
    public enum TypeCard {
        AMARILLA,  // Yellow card
        ROJA,     // Red card
    }

    private Player playerWithCard;
    private int numberCards;
    private TypeCard typeCard;
    private List<Referee> cardAssignByReferee;

    /**
     * Constructor for the Card class.
     * 
     * @param playerWithCard The player who received the card.
     * @param numberCards The number of cards the player has received.
     * @param typeCard The type of card (Yellow or Red).
     */
    public Card(Player playerWithCard, int numberCards, TypeCard typeCard) {
        this.playerWithCard = playerWithCard;
        this.numberCards = numberCards;
        this.typeCard = typeCard;
    }

    /**
     * Gets the player who received the card.
     * 
     * @return The player with the card.
     */
    public Player getPlayerWithCard() {
        return playerWithCard;
    }

    /**
     * Sets the player who received the card.
     * 
     * @param playerWithCard The player who received the card.
     */
    public void setPlayerWithCard(Player playerWithCard) {
        this.playerWithCard = playerWithCard;
    }

    /**
     * Gets the number of cards the player has received.
     * 
     * @return The number of cards.
     */
    public int getNumberCards() {
        return numberCards;
    }

    /**
     * Sets the number of cards the player has received.
     * 
     * @param numberCards The number of cards to set.
     */
    public void setNumberCards(int numberCards) {
        this.numberCards = numberCards;
    }

    /**
     * Gets the type of card that was assigned.
     * 
     * @return The type of card (Yellow or Red).
     */
    public TypeCard getTypeCard() {
        return typeCard;
    }

    /**
     * Sets the type of card that was assigned.
     * 
     * @param typeCard The type of card (Yellow or Red).
     */
    public void setTypeCard(TypeCard typeCard) {
        this.typeCard = typeCard;
    }

    /**
     * Gets the list of referees who assigned the card.
     * 
     * @return A list of referees who assigned the card.
     */
    public List<Referee> getCardAssignByReferee() {
        return cardAssignByReferee;
    }

    /**
     * Sets the list of referees who assigned the card.
     * 
     * @param cardAssignByReferee The list of referees who assigned the card.
     */
    public void setCardAssignByReferee(List<Referee> cardAssignByReferee) {
        this.cardAssignByReferee = cardAssignByReferee;
    }
}