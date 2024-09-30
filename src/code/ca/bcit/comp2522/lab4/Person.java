package ca.bcit.comp2522.lab4;

public class Person
{   /* create variable name */
    private final Name name;
    /* create variable birthDate */
    private final Date dateOfBirth;
    /* create variable deathDate */
    private final Date dateOfDeath;

    public Person(Name name, Date dateOfBirth, Date dateOfDeath) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
    }
}
