package model;

public abstract class Person {

    protected String name;
    protected String country;

    /**
     * Constructor for the Person class.
     * 
     * @param name The name of the person.
     * @param country The country of the person.
     */
    public Person(String name, String country) {
        this.name = name;
        this.country = country;
    }

    /**
     * Gets the name of the person.
     * 
     * @return The name of the person.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the person.
     * 
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the country of the person.
     * 
     * @return The country of the person.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the country of the person.
     * 
     * @param country The country to set.
     */
    public void setCountry(String country) {
        this.country = country;
    }
}
