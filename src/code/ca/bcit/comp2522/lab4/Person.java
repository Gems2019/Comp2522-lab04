package ca.bcit.comp2522.lab4;

/**
 * Represents an abstract Person with a name, date of birth, and date of death.
 * Implements Printable, Comparable<Person>, and Reversible interfaces.
 * The Person class is designed to be inherited by more specific person types.
 * Provides functionality to compare persons by their date of birth, display details,
 * and print the reversed full name.
 *
 * @author Yuho Lim
 * @version 1.0
 */
public class Person implements Printable, Comparable<Person>, Reversible {

    private final Name name;
    private final Date dateOfBirth;
    private final Date dateOfDeath;

    /**
     * Constructs a new Person with the specified name, date of birth, and date of death.
     * The name and date of birth must be non-null, while the date of death can be null
     * for persons who are still alive.
     *
     * @param name the name of the person
     * @param dateOfBirth the date of birth of the person
     * @param dateOfDeath the date of death of the person, or null if still alive
     * @throws IllegalArgumentException if the name or date of birth is null
     */
    public Person(final Name name,
                  final Date dateOfBirth,
                  final Date dateOfDeath) {

        validateDateOfBirth(dateOfBirth);
        validateName(name);

        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
    }

    /**
     * Validates that the date of birth is not null.
     *
     * @param dateOfBirth the date of birth to validate
     * @throws IllegalArgumentException if dateOfBirth is null
     */
    private void validateDateOfBirth(final Date dateOfBirth){

        if(dateOfBirth == null){

            throw new IllegalArgumentException("Enter the date of birth");

        }

    }

    public Name getName(){
        return name;
    }

    /**
     * Gets the date of death of the person. If the person is still alive, this will return null.
     *
     * @return the date of death, or null if the person is still alive
     */
    public Date getDateOfDeath() {
        return dateOfDeath;
    }

    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    /**
     * Validates that the name is not null.
     *
     * @param name the name to validate
     * @throws IllegalArgumentException if name is null
     */
    private void validateName(final Name name){

        if(name == null){

            throw new IllegalArgumentException("Enter the name of the person");

        }

    }

    /**
     * Compares this person with another person by their date of birth in reverse order.
     * A later date of birth will be considered less than an earlier one.
     *
     * @param other the other person to be compared
     * @return a negative integer, zero, or a positive integer as this person's date of birth
     *         is after, equal to, or before the specified person's date of birth
     */
    @Override
    public int compareTo(final Person other) {
        return other.dateOfBirth.compareTo(this.dateOfBirth);
    }

    /**
     * Displays the full details of the person, including their full name, date of birth,
     * and date of death (or indicates if still alive).
     */
    @Override
    public void display(){
        StringBuilder sb = new StringBuilder();

        sb.append("Name : ")
            .append(name.getFullName())
            .append(", Date of birth : ")
            .append(dateOfBirth)
            .append(", Date of death : ")
            .append(dateOfDeath == null ? "Still alive" : dateOfDeath);

        System.out.println(sb.toString());
    }

    /**
     * Reverses the full name of the person and prints it.
     */
    @Override
    public void backward(){
        StringBuilder sb = new StringBuilder(name.getFullName());
        System.out.println(sb.reverse().toString());
    }
}
