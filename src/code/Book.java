public class Book {

    // Constants for validation
    private static final int MAX_TITLE_LENGTH = 100;
    private static final int MIN_YEAR = 1;

    // Data members
    private final String title;
    private final int yearPublished;
    private final Author author;

    // Constructor
    public Book(String title, 
            int yearPublished, 
            Author author) {
        this.title = validateTitle(title);
        this.yearPublished = validateYearPublished(yearPublished);
        this.author = validateAuthor(author);
    }

    // Static method to validate title
    private static String validateTitle(String title) {

        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be null or blank.");
        }

        if (title.length() > MAX_TITLE_LENGTH) {
            throw new IllegalArgumentException("Title cannot exceed " + MAX_TITLE_LENGTH + " characters.");
        }

        return title;
    }

    // Static method to validate yearPublished
    private static int validateYearPublished(int yearPublished) {
        int private currentYear;
        currentYear = Year.now().getValue();
        
        if (yearPublished < MIN_YEAR || yearPublished > currentYear) {
            throw new IllegalArgumentException("Year published must be between " + MIN_YEAR + " and the current year.");
        }

        return yearPublished;
    }

    // Static method to validate author
    private static Author validateAuthor(Author author) {

        if (author == null) {
            throw new IllegalArgumentException("Author cannot be null.");
        }

        return author;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public Author getAuthor() {
        return author;
    }

    // Override toString
    @Override
    public String toString() {
        return "Book [Title: " + title + ", Year Published: " + yearPublished + ", Author: " + author + "]";
    }

    // Override equals and hashCode
    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        } 

        if (obj == null || getClass() != obj.getClass()){
            return false;
        } 

        Book book = (Book) obj;
        return yearPublished == book.yearPublished &&
               Objects.equals(title, book.title) &&
               Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, yearPublished, author);
    }
}
