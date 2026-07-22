package az.edu.library.library_management.services;

import az.edu.library.library_management.dtos.book.BookCreateDto;
import az.edu.library.library_management.dtos.book.BookResponseDto;
import az.edu.library.library_management.dtos.book.BookUpdateDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface BookService {
    Page<BookResponseDto> getAllBooks(Pageable pageable);
    BookResponseDto getBookById(Long id);
    BookResponseDto createBook(BookCreateDto createDto);
    BookResponseDto updateBook(Long id, BookUpdateDto updateDto);
    void deleteBook(Long id);
}
