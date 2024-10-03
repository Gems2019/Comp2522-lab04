package ca.bcit.comp2522.lab4;

/**
 * Represents an abstract Person with a name, date of birth, and date of death.
 * Implements Printable, Comparable&lt;Person&gt;, and Reversible interfaces.
 * The Person class is designed to be inherited by more specific person types.
 * Provides functionality to compare persons by their date of birth, display details,
 * and print the reversed full name.
 *
 * @author Yuho Lim
 * @author Daniil Yarygin
 * @author Kyle Lau
 * @author Gem Baojimin Sha
 * @version 1.0
 */
public class Person implements Printable, Comparable<Person>, Reversible
{

    private final Name name;
    private final Date dateOfBirth;
    private final Date dateOfDeath;

    /**
     * Constructs a new Person with the specified name, date of birth, and date of death.
     * The name and date of birth must be non-null, while the date of death can be null
     * for persons who are still alive.
     *
     * @param name        the name of the person
     * @param dateOfBirth the date of birth of the person
     * @param dateOfDeath the date of death of the person, or null if still alive
     * @throws IllegalArgumentException if the name or date of birth is null
     */
    public Person(final Name name,
                  final Date dateOfBirth,
                  final Date dateOfDeath)
    {

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
    private void validateDateOfBirth(final Date dateOfBirth)
    {

        if(dateOfBirth == null)
        {

            throw new IllegalArgumentException("Enter the date of birth");

        }
    }

    /**
     * Returns the name of the person.
     *
     * @return the name of the person
     */
    public Name getName()
    {
        return name;
    }

    /**
     * Returns the date of birth of the person.
     *
     * @return the date of birth of the person
     */
    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    /**
     * Returns the date of death of the person. If the person is still alive, this will return null.
     *
     * @return the date of death, or null if the person is still alive
     */
    public Date getDateOfDeath()
    {
        return dateOfDeath;
    }

    /**
     * Validates that the name is not null.
     *
     * @param name the name to validate
     * @throws IllegalArgumentException if the name is null
     */
    private void validateName(final Name name)
    {

        if(name == null)
        {

            throw new IllegalArgumentException("Enter the name of the person");

        }
    }

    /**
     * Compares this person with another person by their date of birth in reverse order.
     * A later date of birth will be considered less than an earlier one.
     *
     * @param other the other person to be compared
     * @return a negative integer, zero, or a positive integer as this person's date of birth
     * is after, equal to, or before the specified person's date of birth
     */
    @Override
    public int compareTo(final Person other)
    {
        return other.dateOfBirth.compareTo(this.dateOfBirth);
    }

    /**
     * Returns a string representation of the person, including their full name, date of birth,
     * and date of death (or indicates if still alive).
     *
     * @return the string representation of the person
     */
    @Override
    public String toString()
    {
        return name.getFullName() + " (Born: " + dateOfBirth +
                (dateOfDeath != null ? ", Died: " + dateOfDeath : ", Still alive") + ")";
    }

    /**
     * Displays the full details of the person, including their full name, date of birth,
     * and date of death. If the person is still alive, it indicates "Still alive"
     * instead of a date of death.
     * <p>
     * The full name is retrieved using the {@code getFullName()} method from the {@code Name} class,
     * and both the date of birth and date of death (if applicable) are displayed.
     */
    @Override
    public void display()
    {
        final StringBuilder display;
        display = new StringBuilder();

        display.append("Name : ")
                .append(name.getFullName())
                .append(", Date of birth : ")
                .append(dateOfBirth)
                .append(", Date of death : ")
                .append(dateOfDeath == null ? "Still alive" : dateOfDeath);

        System.out.println(display.toString());
    }

    /**
     * Reverses the full name of the person and prints it.
     * The full name is retrieved using the {@code getFullName()} method from the {@code Name} class,
     * and the reversed version of the name is printed to the console.
     */
    @Override
    public void backward()
    {
        final StringBuilder backward;
        backward = new StringBuilder(name.getFullName());
        System.out.println(backward.reverse().toString());
    }
}
