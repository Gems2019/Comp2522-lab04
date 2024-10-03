package ca.bcit.comp2522.lab4;

/**
 * The Main class serves as the entry point for creating and comparing different types of books:
 * Books, Biographies, and Autobiographies. It demonstrates the functionality of various classes
 * including `Book`, `Biography`, `Autobiography`, `Author`, `Person`, and `Name`.
 *
 * <p>In the main method, several books, biographies, and autobiographies are created,
 * and different comparisons between them are made. The program uses the following features:
 * <ul>
 *     <li>Creating instances of `Book`, `Biography`, and `Autobiography`</li>
 *     <li>Comparing books by year of publication</li>
 *     <li>Comparing authors by birthdate</li>
 *     <li>Comparing biographies by subject (Person)</li>
 *     <li>Displaying details of each book, biography, and autobiography using the `Printable` interface</li>
 *     <li>Printing book titles and author names backward using the `Reversible` interface</li>
 * </ul>
 *
 * @author Yuho Lim
 * @author Daniil Yarygin
 * @author Kyle Lau
 * @author Gem Baojimin Sha
 * @version 1.0
 */
public class Main {

    /**
     * The main method of the program. It creates several books, biographies, and autobiographies,
     * performs various comparisons, and prints details of the objects.
     *
     * @param args the command-line arguments (not used in this program)
     */
    public static void main(final String[] args) {

        // Creating instances of Book, Biography, and Autobiography.

        // 5 Books
        Book book1 = new Book("1984", 1949, new Author(new Name("George", "Orwell"),
                new Date(1903, 6, 25), null, "Dystopian Fiction"));

        Book book2 = new Book("To Kill a Mockingbird", 1960, new Author(new Name("Harper", "Lee"),
                new Date(1926, 4, 28), new Date(2016, 2, 19), "Fiction"));

        Book book3 = new Book("Pride and Prejudice", 1813, new Author(new Name("Jane", "Austen"),
                new Date(1775, 12, 16), new Date(1817, 7, 18), "Romance"));

        Book book4 = new Book("The Great Gatsby", 1925, new Author(new Name("F. Scott", "Fitzgerald"),
                new Date(1896, 9, 24), new Date(1940, 12, 21), "Tragedy"));

        Book book5 = new Book("Moby-Dick", 1851, new Author(new Name("Herman", "Melville"),
                new Date(1819, 8, 1), new Date(1891, 9, 28), "Adventure"));

        // 5 Biographies
        Biography bio1 = new Biography("The Power Broker", 1974, new Author(new Name("Robert", "Caro"),
                new Date(1935, 10, 30), null, "Biography"),
                new Person(new Name("Robert", "Moses"), new Date(1888, 12, 18),
                        new Date(1981, 7, 29)));

        Biography bio2 = new Biography("Steve Jobs", 2011,
                new Author(new Name("Walter", "Isaacson"),
                        new Date(1952, 5, 20), null, "Biography"),
                new Person(new Name("Steve", "Jobs"), new Date(1955, 2, 24),
                        new Date(2011, 10, 5)));

        Biography bio3 = new Biography("Churchill: A Life", 1991,
                new Author(new Name("Martin", "Gilbert"),
                        new Date(1936, 10, 25),
                        new Date(2015, 2, 3), "History"),
                new Person(new Name("Winston", "Churchill"),
                        new Date(1874, 11, 30),
                        new Date(1965, 1, 24)));

        Biography bio4 = new Biography("Alexander Hamilton", 2004,
                new Author(new Name("Ron", "Chernow"),
                        new Date(1949, 3, 3), null, "History"),
                new Person(new Name("Alexander", "Hamilton"), new Date(1755, 1, 11),
                        new Date(1804, 7, 12)));

        Biography bio5 = new Biography("Einstein: His Life and Universe", 2007,
                new Author(new Name("Walter", "Isaacson"),
                        new Date(1952, 5, 20), null, "Science"),
                new Person(new Name("Albert", "Einstein"),
                        new Date(1879, 3, 14),
                        new Date(1955, 4, 18)));

        // 5 Autobiographies
        Autobiography auto1 = new Autobiography("The Diary of a Young Girl", 1947,
                new Author(new Name("Anne", "Frank"), new Date(1929, 6, 12),
                        new Date(1945, 3, 31), "Memoir"));
        Autobiography auto2 = new Autobiography("Long Walk to Freedom", 1994,
                new Author(new Name("Nelson", "Mandela"), new Date(1918, 7, 18),
                        new Date(2013, 12, 5), "Memoir"));

        Autobiography auto3 = new Autobiography("The Story of My Experiments with Truth", 1927,
                new Author(new Name("Mahatma", "Gandhi"), new Date(1869, 10, 2),
                        new Date(1948, 1, 30), "Memoir"));

        Autobiography auto4 = new Autobiography("I Know Why the Caged Bird Sings", 1969,
                new Author(new Name("Maya", "Angelou"),
                        new Date(1928, 4, 4),
                        new Date(2014, 5, 28), "Memoir"));

        Autobiography auto5 = new Autobiography("Autobiography of Malcolm X", 1965,
                new Author(new Name("Malcolm", "X"),
                        new Date(1925, 5, 19),
                        new Date(1965, 2, 21), "Memoir"));

        // Comparing books by year of publication
        System.out.println("Comparing book1 and book2 by year: " + book1.compareTo(book2));

        // Comparing authors by birthdate
        System.out.println("Comparing author of book1 and book2 by birthdate: " + book1.getAuthor().compareTo(book2.getAuthor()));

        // Comparing biographies by subjects (Person)
        System.out.println("Comparing bio1 and bio2 by subjects: " + bio1.getSubject().compareTo(bio2.getSubject()));

        // Displaying details for each book, biography, and autobiography
        System.out.println("\nPrinting details of each book:");
        book1.display();
        book2.display();
        book3.display();
        book4.display();
        book5.display();

        System.out.println("\nPrinting details of each biography:");
        bio1.display();
        bio2.display();
        bio3.display();
        bio4.display();
        bio5.display();

        System.out.println("\nPrinting details of each autobiography:");
        auto1.display();
        auto2.display();
        auto3.display();
        auto4.display();
        auto5.display();

        // Reversing book titles and author names
        System.out.println("\nPrinting book titles and author names backward:");
        book1.backward();
        book2.backward();
        book3.backward();
        book4.backward();
        book5.backward();
    }
}

