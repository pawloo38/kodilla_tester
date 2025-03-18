package com.kodilla.rest.service;

import com.kodilla.rest.domain.BookDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {

    private BookService bookService;
    private BookDto book1;
    private BookDto book2;

    @BeforeEach
    void setUp() {
        bookService = new BookService();
        book1 = new BookDto("Java Programming", "John Doe");
        book2 = new BookDto("Python Programming", "Jane Doe");
    }

    @Test
    void shouldReturnEmptyListInitially() {
        // Given


        // When
        var books = bookService.getBooks();

        // Then
        assertTrue(books.isEmpty(), "The list of books should be empty initially.");
    }

    @Test
    void shouldAddBook() {
        // Given


        // When
        bookService.addBook(book1);
        bookService.addBook(book2);
        var books = bookService.getBooks();

        // Then
        assertEquals(2, books.size(), "The list of books should contain 2 books.");
        assertTrue(books.contains(book1), "The list should contain the book 'Java Programming'.");
        assertTrue(books.contains(book2), "The list should contain the book 'Python Programming'.");
    }

    @Test
    void shouldRemoveBook() {
        // Given
        bookService.addBook(book1);
        bookService.addBook(book2);

        // When
        bookService.removeBook(book1);
        var books = bookService.getBooks();

        // Then
        assertEquals(1, books.size(), "The list of books should contain 1 book.");
        assertFalse(books.contains(book1), "The list should not contain the book 'Java Programming'.");
        assertTrue(books.contains(book2), "The list should still contain the book 'Python Programming'.");
    }
}