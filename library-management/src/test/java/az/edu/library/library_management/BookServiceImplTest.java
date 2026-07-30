package az.edu.library.library_management;

import az.edu.library.library_management.dtos.book.BookCreateDto;
import az.edu.library.library_management.dtos.book.BookResponseDto;
import az.edu.library.library_management.exceptions.ResourceNotFoundException;
import az.edu.library.library_management.models.Author;
import az.edu.library.library_management.models.Book;
import az.edu.library.library_management.repositories.AuthorRepository;
import az.edu.library.library_management.repositories.BookRepository;
import az.edu.library.library_management.services.impls.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookServiceImplTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private AuthorRepository authorRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private BookServiceImpl bookService;

    @Test
    void getBookById_ShouldReturnBook_WhenBookExists() {
        Long bookId = 1L;

        Author author = new Author();
        author.setId(1L);

        Book book = new Book();
        book.setId(bookId);
        book.setTitle("Java Programming");
        book.setAuthor(author);

        BookResponseDto responseDto = new BookResponseDto();
        responseDto.setId(bookId);
        responseDto.setTitle("Java Programming");
        responseDto.setAuthorId(1L);

        when(bookRepository.findById(bookId)).thenReturn(Optional.of(book));
        when(modelMapper.map(book, BookResponseDto.class)).thenReturn(responseDto);

        BookResponseDto result = bookService.getBookById(bookId);

        assertNotNull(result);
        assertEquals(bookId, result.getId());
        assertEquals("Java Programming", result.getTitle());
        verify(bookRepository, times(1)).findById(bookId);
    }

    @Test
    void getBookById_ShouldThrowException_WhenBookDoesNotExist() {
        Long bookId = 1L;
        when(bookRepository.findById(bookId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            bookService.getBookById(bookId);
        });

        verify(bookRepository, times(1)).findById(bookId);
    }

    @Test
    void createBook_ShouldReturnSavedBook_WhenAuthorExists() {
        Long authorId = 1L;

        BookCreateDto createDto = new BookCreateDto();
        createDto.setTitle("Spring Boot Guide");
        createDto.setAuthorId(authorId);

        Author author = new Author();
        author.setId(authorId);

        Book mappedBook = new Book();
        mappedBook.setTitle("Spring Boot Guide");

        Book savedBook = new Book();
        savedBook.setId(1L);
        savedBook.setTitle("Spring Boot Guide");
        savedBook.setAuthor(author);

        BookResponseDto responseDto = new BookResponseDto();
        responseDto.setId(1L);
        responseDto.setTitle("Spring Boot Guide");
        responseDto.setAuthorId(authorId);

        when(authorRepository.findById(authorId)).thenReturn(Optional.of(author));
        when(modelMapper.map(createDto, Book.class)).thenReturn(mappedBook);
        when(bookRepository.save(any(Book.class))).thenReturn(savedBook);
        when(modelMapper.map(savedBook, BookResponseDto.class)).thenReturn(responseDto);

        BookResponseDto result = bookService.createBook(createDto);

        assertNotNull(result);
        assertEquals("Spring Boot Guide", result.getTitle());
        assertEquals(authorId, result.getAuthorId());
        verify(authorRepository, times(1)).findById(authorId);
        verify(bookRepository, times(1)).save(any(Book.class));
    }
}