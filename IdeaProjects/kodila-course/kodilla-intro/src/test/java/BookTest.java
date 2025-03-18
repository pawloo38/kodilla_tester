import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BookTest {
    @Test
    void testOfMethod() {
        // Given
        String author = "Adam Mickiewicz";
        String title = "Pan Tadeusz";

        // When
        Book book = Book.of(author, title);

        // Then
        assertNotNull(book, "Obiekt Book nie powinien być null.");
        assertEquals(author, book.getAuthor(), "Autor powinien być 'Adam Mickiewicz'.");
        assertEquals(title, book.getTitle(), "Tytuł powinien być 'Pan Tadeusz'.");
    }

    @Test
    void testGetAuthor() {
        // Given
        String author = "Henryk Sienkiewicz";
        String title = "Quo Vadis";
        Book book = Book.of(author, title);

        // When
        String retrievedAuthor = book.getAuthor();

        // Then
        assertEquals(author, retrievedAuthor, "Metoda getAuthor powinna zwrócić poprawnego autora.");
    }

    @Test
    void testGetTitle() {
        // Given
        String author = "Bolesław Prus";
        String title = "Lalka";
        Book book = Book.of(author, title);

        // When
        String retrievedTitle = book.getTitle();

        // Then
        assertEquals(title, retrievedTitle, "Metoda getTitle powinna zwrócić poprawny tytuł.");
    }
}
