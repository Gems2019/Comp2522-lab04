package ca.bcit.comp2522.lab4;

/**
 * The {@code Name} class represents a person's name with a first name and a last name.
 * It provides validation for both names and methods to retrieve the full name.
 *
 * <p>The class ensures that neither the first name nor the last name exceeds a specified
 * maximum length ({@value NAME_LEN}) or is blank/null. If a name does not meet these criteria,
 * an {@code IllegalArgumentException} is thrown.</p>
 *
 * @author Yuho Lim
 * @author Daniil Yarygin
 * @author Kyle Lau
 * @author Gem Baojimin Sha
 * @version 1.0
 */
public class Name
{
    /**
     * The first name of the person.
     */
    private final String firstName;

    /**
     * The last name of the person.
     */
    private final String lastName;

    /**
     * The maximum length allowed for first and last names.
     */
    private static final int NAME_LEN = 50;

    /**
     * Constructs a {@code Name} object with the specified first and last names.
     *
     * @param firstName the first name of the person
     * @param lastName  the last name of the person
     * @throws IllegalArgumentException if the first or last name is null, blank, or exceeds 50 characters
     */
    public Name(final String firstName,
                final String lastName)
    {

        validateFirstName(firstName);
        validateLastName(lastName);

        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Returns the full name by concatenating the first name and the last name with a space in between.
     *
     * @return the full name as a string in the format "firstName lastName"
     */
    public final String getFullName()
    {
        return firstName + " " + lastName;
    }

    /**
     * Validates the first name, ensuring it is not null, blank, or longer than {@value NAME_LEN}.
     *
     * @param firstName the first name to be validated
     * @throws IllegalArgumentException if the first name is invalid
     */
    private static void validateFirstName(final String firstName)
    {

        if(firstName == null || firstName.isBlank() || firstName.length() > NAME_LEN)
        {

            throw new IllegalArgumentException("bad First Name: " + firstName);

        }
    }

    /**
     * Validates the last name, ensuring it is not null, blank, or longer than {@value NAME_LEN}.
     *
     * @param lastName the last name to be validated
     * @throws IllegalArgumentException if the last name is invalid
     */
    private static void validateLastName(final String lastName)
    {

        if(lastName == null || lastName.isBlank() || lastName.length() > NAME_LEN)
        {

            throw new IllegalArgumentException("bad Last Name: " + lastName);

        }
    }

    /**
     * Returns the full name in "First Last" format.
     *
     * @return the full name as a string
     */
    @Override
    public String toString()
    {
        return getFullName();
    }
}
