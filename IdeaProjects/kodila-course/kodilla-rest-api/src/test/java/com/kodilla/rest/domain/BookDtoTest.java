package com.kodilla.rest.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookDtoTest {

    @Test
    void shouldCreateBookDtoUsingConstructor() {
        // Given
        String title = "Java Programming";
        String author = "John Doe";

        // When
        BookDto bookDto = new BookDto(title, author);

        // Then
        assertEquals(title, bookDto.getTitle());
        assertEquals(author, bookDto.getAuthor());
    }

    @Test
    void shouldReturnTrueForEqualBooks() {
        // Given
        BookDto bookDto1 = new BookDto("Java Programming", "John Doe");
        BookDto bookDto2 = new BookDto("Java Programming", "John Doe");

        // When & Then
        assertEquals(bookDto1, bookDto2);
    }

    @Test
    void shouldReturnFalseForDifferentBooks() {
        // Given
        BookDto bookDto1 = new BookDto("Java Programming", "John Doe");
        BookDto bookDto2 = new BookDto("Python Programming", "Jane Doe");

        // When & Then
        assertNotEquals(bookDto1, bookDto2);
    }

    @Test
    void shouldReturnSameHashCodeForEqualBooks() {
        // Given
        BookDto bookDto1 = new BookDto("Java Programming", "John Doe");
        BookDto bookDto2 = new BookDto("Java Programming", "John Doe");

        // When & Then
        assertEquals(bookDto1.hashCode(), bookDto2.hashCode());
    }

    @Test
    void shouldReturnDifferentHashCodeForDifferentBooks() {
        // Given
        BookDto bookDto1 = new BookDto("Java Programming", "John Doe");
        BookDto bookDto2 = new BookDto("Python Programming", "Jane Doe");

        // When & Then
        assertNotEquals(bookDto1.hashCode(), bookDto2.hashCode());
    }
}