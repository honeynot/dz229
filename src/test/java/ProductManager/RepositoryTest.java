package ProductManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepositoryTest {
    @Test
    public void testRemoveWhenProductExist() {
        Repository repo = new Repository();
        Book book1 = new Book(1, "Lord of the ring I", 100, "Tolkien");
        Book book2 = new Book(2, "Hobbit", 200, "Tolkien");
        Book book3 = new Book(3, "Lord of the ring III", 300, "Tolkien");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.removeById(1);
        Product[] actual = repo.findAll();
        Product[] expected = {book2, book3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveWhenProductNotExist() {
        Repository repo = new Repository();
        Book book1 = new Book(1, "Lord of the ring I", 100, "Tolkien");
        Book book2 = new Book(2, "Hobbit", 200, "Tolkien");
        Book book3 = new Book(3, "Lord of the ring III", 300, "Tolkien");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        Assertions.assertThrows(NotFoundException.class,
                () -> repo.removeById(4)
        );
    }
}
