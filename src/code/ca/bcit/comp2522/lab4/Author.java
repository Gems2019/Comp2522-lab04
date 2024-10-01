package ca.bcit.comp2522.lab4;

/**
 * Represents an Author who extends the Person class.
 * The Author class includes the genre of writing.
 * Implements the Printable interface to display author details.
 *
 * @author Yuho Lim
 * @version 1.0
 */
public class Author extends Person implements Printable {

    private String genre;

    /**
     * Constructs an Author object with the specified name, date of birth, and date of death.
     *
     * @param name the full name of the author, cannot be null
     * @param dateOfBirth the author's date of birth, cannot be null
     * @param dateOfDeath the author's date of death, can be null if the author is still alive
     * @throws IllegalArgumentException if the genre is null, blank, or exceeds 30 characters
     */
    public Author(final Name name,
                  final Date dateOfBirth,
                  final Date dateOfDeath,
                  final String genre) {

        super(name, dateOfBirth, dateOfDeath);

        validateGenre(genre);

        this.genre = genre;
    }

    /**
     * Validates the genre of the author.
     *
     * @param genre the genre to be validated
     * @throws IllegalArgumentException if the genre is null, blank, or exceeds 30 characters
     */
    private void validateGenre(final String genre) {

        if (genre == null || genre.isBlank()) {
            throw new IllegalArgumentException("Genre must be filled up");
        }

        if (genre.length() > 30) {
            throw new IllegalArgumentException("Genre must be less than 30 characters");
        }
    }

    @Override
    public String toString() {
        return getName().getFullName() + " (Genre: " + genre + ")";
    }


    /**
     * Displays the details of the author including name, date of birth, and genre.
     * Implements the display method from the Printable interface.
     */
    @Override
    public void display() {
        StringBuilder authorInformation = new StringBuilder();

        authorInformation.append("Name : ")
                .append(getName().getFullName())
                .append(", Date of birth : ")
                .append(getDateOfBirth())
                .append(", Genre : ")
                .append(genre);

        System.out.println(authorInformation.toString());
    }


}
