package ca.bcit.comp2522.lab4;

public class Name implements Printable
{   private final String firstName;
    private final String lastName;
    private static final int NAME_LEN= 50;


    public Name(final String firstName, final String lastName) {
        validateFirstName(firstName);
        validateLastName(lastName);

        this.firstName = firstName;
        this.lastName = lastName;
    }
    private static void validateFirstName(final String firstName) {
        if (firstName == null || firstName.isBlank() || firstName.length() > NAME_LEN) {
            throw new IllegalArgumentException("bad First Name: " + firstName);
        }

    }

    private static void validateLastName(final String lastName) {
        if (lastName == null || lastName.isBlank() || lastName.length() > NAME_LEN) {
            throw new IllegalArgumentException("bad Last Name: " + lastName);
        }
    }




}
