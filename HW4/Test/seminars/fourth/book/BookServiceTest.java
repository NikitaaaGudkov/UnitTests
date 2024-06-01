package seminars.fourth.book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceTest {

    private BookRepository bookRepositoryMock;

    @BeforeEach
    void SetUp() {
        bookRepositoryMock = mock(BookRepository.class);
    }

    @Test
    void findBookById() {
        Book expectedBook = new Book("1", "Book1", "Author1");
        when(bookRepositoryMock.findById("1")).thenReturn(expectedBook);
        BookService bookService = new BookService(bookRepositoryMock);
        Book actualBook = bookService.findBookById("1");
        assertThat(actualBook).isEqualTo(expectedBook);
        verify(bookRepositoryMock, times(1)).findById("1");
    }

    @Test
    void findAllBooks() {
        Book book1 = new Book("1", "Book1", "Author1");
        Book book2 = new Book("2", "Book2", "Author2");

        ArrayList<Book> expectedBooks = new ArrayList<>();
        expectedBooks.add(book1);
        expectedBooks.add(book2);

        when(bookRepositoryMock.findAll()).thenReturn(expectedBooks);
        BookService bookService = new BookService(bookRepositoryMock);
        List<Book> actualBooks = bookService.findAllBooks();
        assertThat(actualBooks).containsExactlyInAnyOrderElementsOf(expectedBooks);
        verify(bookRepositoryMock, times(1)).findAll();
    }
}