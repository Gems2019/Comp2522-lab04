package ca.bcit.comp2522.lab4;

import java.time.Year;
import java.util.Objects;

/**
 * Represents a book with a title, year of publication, and an author.
 * Implements {@code Comparable<Book>}, {@code Printable}, and {@code Reversible} interfaces.
 * Validates the title, year of publication, and author upon instantiation.
 *
 * @author Yuho Lim
 * @author Daniil Yarygin
 * @author Kyle Lau
 * @author Gem Baojimin Sha
 * @version 1.0
 */
public class Book implements Comparable<Book>, Printable, Reversible
{

    // Constants for validation
    private static final int MAX_TITLE_LENGTH = 100;
    private static final int MIN_YEAR = 1;

    // Data members
    private final String title;
    private final int yearPublished;
    private final Author author;

    /**
     * Constructs a new {@code Book} with the specified title, year of publication, and author.
     *
     * @param title         the title of the book, must not be null, blank, or exceed a hundred characters
     * @param yearPublished the year the book was published, must be between one and the current year
     * @param author        the author of the book, must not be null
     */
    public Book(final String title,
                final int yearPublished,
                final Author author)
    {
        this.title = validateTitle(title);
        this.yearPublished = validateYearPublished(yearPublished);
        this.author = validateAuthor(author);
    }

    /**
     * Validates the book's title.
     *
     * @param title the title to validate
     * @return the validated title
     * @throws IllegalArgumentException if the title is null, blank, or exceeds the maximum length
     */
    private static String validateTitle(final String title)
    {

        if(title == null || title.isBlank())
        {

            throw new IllegalArgumentException("Title cannot be null or blank.");
        }

        if(title.length() > MAX_TITLE_LENGTH)
        {

            throw new IllegalArgumentException("Title cannot exceed " + MAX_TITLE_LENGTH + " characters.");

        }
        return title;
    }

    /**
     * Validates the year of publication.
     *
     * @param yearPublished the year to validate
     * @return the validated year
     */
    private static int validateYearPublished(final int yearPublished)
    {

        int currentYear = Year.now().getValue();

        if(yearPublished < MIN_YEAR || yearPublished > currentYear)
        {

            throw new IllegalArgumentException("Year published must be between " + MIN_YEAR + " and the current year.");

        }
        return yearPublished;
    }

    /**
     * Validates the author of the book.
     *
     * @param author the author to validate
     * @return the validated author
     */
    private static Author validateAuthor(final Author author)
    {

        if(author == null)
        {

            throw new IllegalArgumentException("Author cannot be null.");

        }
        return author;
    }

    /**
     * Returns the title of the book.
     *
     * @return the book's title
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Returns the year the book was published.
     *
     * @return the year of publication
     */
    public int getYearPublished()
    {
        return yearPublished;
    }

    /**
     * Returns the author of the book.
     *
     * @return the author of the book
     */
    public Author getAuthor()
    {
        return author;
    }

    /**
     * Returns a string representation of the book, including its title, year of publication, and author.
     *
     * @return a string representation of the book
     */
    @Override
    public String toString()
    {
        return "Book [Title: " + title + ", Year Published: " + yearPublished + ", Author: " + author + "]";
    }

    /**
     * Checks if this book is equal to another object. Books are considered equal if they have the same title,
     * year of publication, and author.
     *
     * @param obj the object to compare to
     * @return {@code true} if this book is equal to the specified object, {@code false} otherwise
     */
    @Override
    public boolean equals(Object obj)
    {

        if(this == obj)
        {

            return true;

        }

        if(obj == null || getClass() != obj.getClass())
        {

            return false;

        }

        Book book;
        book = (Book) obj;

        return yearPublished == book.yearPublished &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author);
    }

    /**
     * Returns a hash code for this book based on its title, year of publication, and author.
     *
     * @return a hash code value for this book
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(title, yearPublished, author);
    }

    /**
     * Compares this book to another book by the year of publication. Older books are considered "larger."
     *
     * @param other the book to compare to
     * @return a negative integer, zero, or a positive integer as this book is older than, the same age as,
     * or newer than the specified book
     */
    @Override
    public int compareTo(Book other)
    {
        return Integer.compare(other.yearPublished, this.yearPublished);  // Older books are "larger"
    }

    /**
     * Prints the details of the book, including its title, year of publication, and author.
     */
    @Override
    public void display()
    {
        System.out.println("Title: " + title + ", Year Published: " + yearPublished +
                ", Author: " + author);
    }

    /**
     * Prints the title of the book in reverse order.
     */
    @Override
    public void backward()
    {
        final StringBuilder reversedTitle;
        reversedTitle = new StringBuilder(title);
        System.out.println(reversedTitle.reverse().toString());
    }
}

