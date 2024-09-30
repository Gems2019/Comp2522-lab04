public class Biography extends Book {

    // Data member
    private final Person subject;

    // Constructor
    public Biography(String title, 
                int yearPublished, 
                Author author, 
                Person subject) {
        super(title, yearPublished, author); // Call to the parent class (Book) constructor
        this.subject = validateSubject(subject);
    }

    // Static method to validate subject
    private static Person validateSubject(Person subject) {

        if (subject == null) {
            throw new IllegalArgumentException("Subject cannot be null.");
        }

        return subject;
    }

    // Getter for subject
    public Person getSubject() {
        return subject;
    }

    // Override equals: Two biographies are equal if they are about the same subject
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Biography)){
            return false;
        } 
        S
        Biography otherBiography = (Biography) obj;
        return subject.equals(otherBiography.subject);
    }

    @Override
    public int hashCode() {
        return subject.hashCode();
    }

    // Override toString
    @Override
    public String toString() {
        return "Biography [Title: " + getTitle() + ", Year Published: " + getYearPublished() +
               ", Author: " + getAuthor() + ", Subject: " + subject + "]";
    }
}
