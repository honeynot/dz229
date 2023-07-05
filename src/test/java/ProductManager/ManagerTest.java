package ProductManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerTest {

    @Test
    public void testAdd() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book( 1, "Lord of the ringI", 100, "Tolkien");
        Book book2 = new Book( 2, "Hobbit",  200, "Tolkien");
        Book book3 = new Book( 3, "Lord of the ring III",300, "Tolkien");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, book3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchWhenFewProductsFound() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Lord of the ring I", 100, "Tolkien");
        Book book2 = new Book(2, "Hobbit", 200, "Tolkien");
        Book book3 = new Book(3, "Lord of the ring III", 300, "Tolkien");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = manager.searchBy("Lord");
        Product[] expected = {book1, book3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchWhenNothingProductsFound() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Lord of the ring I", 100, "Tolkien");
        Book book2 = new Book(2, "Hobbit", 200, "Tolkien");
        Book book3 = new Book(3, "Lord of the ring III", 300, "Tolkien");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = manager.searchBy("Island");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchWhenOneProductsFound() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Lord of the ring I", 100, "Tolkien");
        Book book2 = new Book(2, "Hobbit", 200, "Tolkien");
        Book book3 = new Book(3, "Lord of the ring III", 300, "Tolkien");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = manager.searchBy("Hobbit");
        Product[] expected = {book2};

        Assertions.assertArrayEquals(expected, actual);
    }

}
