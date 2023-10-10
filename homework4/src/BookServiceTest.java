import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookServiceTest {
    @Test
    public void findBookByIdTest() {
        // Arrange (Подготовка)
        BookRepository mockRepository = mock(BookRepository.class);
        when(mockRepository.findById("1")).thenReturn(new Book("1", "Test Book", "Test Author"));

        // Act
        BookService bookService = new BookService(mockRepository);
        Book result = bookService.findBookById("1");

        // Assert
        assertEquals("Test Book", result.getTitle());
        assertEquals("Test Author", result.getAuthor());
    }

    @Test
    public void testFindAllBooks() {
        // Arrange (Подготовка)
        BookRepository mockRepository = mock(BookRepository.class);
        when(mockRepository.findAll()).thenReturn(List.of(new Book("1", "Test Book", "Test Author")));

        // Act
        BookService bookService = new BookService(mockRepository);
        List<Book> result = bookService.findAllBooks();

        // Assert
        assertEquals("Test Book", result.get(0).getTitle());
        assertEquals("Test Author", result.get(0).getAuthor());
    }
}
