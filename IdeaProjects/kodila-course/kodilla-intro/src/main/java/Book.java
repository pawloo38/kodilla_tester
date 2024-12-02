public class Book {
    private String author;
    private String title;
    private Book(String author, String title) {
        this.author = author;
        this.title = title;
    }
    public static Book of(String author, String title) {
        return new Book(author, title);
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }
    public static void main(String[] args) {
        Book book = Book.of("Adam Mickiewicz", "Pan Tadeusz");
        System.out.println("Autor: " + book.getAuthor());
        System.out.println("Tytul: " + book.getTitle());

    }
}
