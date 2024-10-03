package ca.bcit.comp2522.lab4;

/**
 * The Biography class represents a book that provides an account of a person's life.
 * It extends the {@link Book} class and implements the {@link Printable} interface.
 * A Biography has a subject, which is the person the biography is about.
 *
 * The class provides methods to access the subject, validate the subject, and
 * print all instance variables including the subject.
 * It overrides {@code equals()}, {@code hashCode()}, {@code toString()}
 * and provides an implementation for {@code display()}.
 *
 * @author Yuho Lim
 * @author Daniil Yarygin
 * @author Kyle Lau
 * @author Gem Baojimin Sha
 * @version 1.0
 */
public class Biography extends Book implements Printable {

    /**
     * The person that the biography is about.
     */
    private final Person subject;

    /**
     * Constructs a Biography object with the given title, year published, author, and subject.
     *
     * @param title the title of the biography.
     * @param yearPublished the year the biography was published.
     * @param author the author of the biography.
     * @param subject the person the biography is about.
     * @throws IllegalArgumentException if the subject is null.
     */
    public Biography(final String title,
                     final int yearPublished,
                     final Author author,
                     final Person subject) {
        super(title, yearPublished, author); // Call the parent class (Book) constructor
        this.subject = validateSubject(subject);
    }

    /**
     * Validates the subject of the biography.
     *
     * @param subject the person the biography is about.
     * @return the validated subject if not null.
     * @throws IllegalArgumentException if the subject is null.
     */
    private static Person validateSubject(final Person subject) {

        if (subject == null) {

            throw new IllegalArgumentException("Subject cannot be null.");

        }
        return subject;
    }

    /**
     * Returns the subject of the biography.
     *
     * @return the subject of the biography.
     */
    public Person getSubject() {
        return subject;
    }

    /**
     * Compares this biography with the specified object for equality.
     * Two biographies are considered equal if they are about the same subject.
     *
     * @param obj the object to be compared.
     * @return {@code true} if the specified object is equal to this biography, otherwise {@code false}.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Biography)) {
            return false;
        }
        Biography otherBiography;
        otherBiography = (Biography) obj;
        return subject.equals(otherBiography.subject);
    }

    /**
     * Returns a hash code value for the biography, based on the subject.
     *
     * @return the hash code value.
     */
    @Override
    public int hashCode() {
        return subject.hashCode();
    }

    /**
     * Prints all instance variables including the subject of the biography.
     * This method is an implementation of the {@link Printable} interface.
     */
    @Override
    public void display() {
        System.out.println("Title: " + getTitle() + ", Year Published: " + getYearPublished() +
                ", Author: " + getAuthor() + ", Subject: " + subject);
    }

    /**
     * Returns a string representation of the biography, including the title,
     * year published, author, and subject.
     *
     * @return a string representation of the biography.
     */
    @Override
    public String toString() {
        return "Biography [Title: " + getTitle() + ", Year Published: " + getYearPublished() +
                ", Author: " + getAuthor() + ", Subject: " + subject + "]";
    }
}
