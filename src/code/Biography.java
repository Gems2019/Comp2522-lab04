public class Biography extends Book implements Printable {

    // Data member
    private final Person subject;

    // Constructor
    public Biography(private String title, 
                private int yearPublished, 
                private Author author, 
                private Person subject) {
        super(title, yearPublished, author); // Call the parent class (Book) constructor
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
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Biography)){
            return false;
        }
        
        Biography otherBiography = (Biography) obj;
        return subject.equals(otherBiography.subject);
    }

    @Override
    public int hashCode() {
        return subject.hashCode();
    }

    // Printable interface implementation: Print all instance variables including the subject
    @Override
    public void display() {
        System.out.println("Title: " + getTitle() + ", Year Published: " + getYearPublished() +
                ", Author: " + getAuthor() + ", Subject: " + subject);
    }

    // Override toString
    @Override
    public String toString() {
        return "Biography [Title: " + getTitle() + ", Year Published: " + getYearPublished() +
               ", Author: " + getAuthor() + ", Subject: " + subject + "]";
    }
}
