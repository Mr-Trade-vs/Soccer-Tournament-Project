package model;

/**
* The Referee class represents a referee in a football tournament, including details such as ID, name, country, and type.
*/
public class Referee extends Person{

    /**
    * Enum representing the type of referee: Central or Assistant.
    */
    public enum typeReferee {
        Central,
        Asistente
    }

    private String idReferee;
    private typeReferee typeReferee;

    /**
    * Constructs a new Referee with the specified details.
    * 
    * @param idReferee The unique identifier of the referee.
    * @param nameReferee The name of the referee.
    * @param countryReferee The country of origin of the referee.
    * @param typeReferee The type of referee (Central or Assistant).
    */
    public Referee(String name, String country, String idReferee, model.Referee.typeReferee typeReferee) {
        super(name, country);
        this.idReferee = idReferee;
        this.typeReferee = typeReferee;
    }

    /**
    * Retrieves the ID of the referee.
    * 
    * @return The referee's ID.
    */
    public String getIdReferee() {
        return idReferee;
    }

    /**
    * Sets the ID of the referee.
    * 
    * @param idReferee The ID to set for the referee.
    */
    public void setIdReferee(String idReferee) {
        this.idReferee = idReferee;
    }

    /**
    * Retrieves the type of the referee (Central or Assistant).
    * 
    * @return The referee's type.
    */
    public typeReferee getTypeReferee() {
        return typeReferee;
    }

    /**
    * Sets the type of the referee.
    * 
    * @param typeReferee The type to set for the referee.
    */
    public void setTypeReferee(typeReferee typeReferee) {
        this.typeReferee = typeReferee;
    }
}
