package ca.bcit.comp2522.lab4;

/**
 * The Autobiography class represents a type of book where the subject and author are the same person.
 * This class extends the Biography class and automatically sets the subject to the author.
 * Implements Printable to display information and Reversible to print the title backward.
 *
 * @author Yuho Lim
 * @author Daniil Yarygin
 * @author Kyle Lau
 * @author Gem Baojimin Sha
 * @version 1.0
 */
public class Autobiography extends Biography {

    /**
     * Constructs an Autobiography object with the given title, year, and author.
     * The subject of the biography is automatically set to the author.
     *
     * @param title The title of the autobiography, must not be null, blank, and less than 100 characters.
     * @param yearPublished The year the autobiography was published, must be between year 1 and the current year.
     * @param author The author of the autobiography, must not be null. The subject will be automatically set to this author.
     */
    public Autobiography(final String title,
                         final int yearPublished,
                         final Author author) {
        super(title, yearPublished, author, author);
    }

    /**
     * Displays the details of the autobiography, including the book title, year published,
     * and author/subject details.
     */
    @Override
    public void display() {
        System.out.println("Autobiography Title: " + getTitle());
        System.out.println("Year Published: " + getYearPublished());
        System.out.println("Author and Subject: " + getAuthor().getName() + " " + getAuthor().getName());
        System.out.println("Author's Date of Birth: " + getAuthor().getDateOfBirth());
        if (getAuthor().getDateOfDeath() != null) {
            System.out.println("Author's Date of Death: " + getAuthor().getDateOfDeath());
        }
    }

    /**
     * Prints the title of the autobiography backward.
     */
    @Override
    public void backward() {
        final StringBuilder reversedTitle;
        reversedTitle = new StringBuilder(getTitle());
        System.out.println("Reversed Title: " + reversedTitle.reverse());
    }
}
