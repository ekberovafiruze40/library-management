package az.edu.library.library_management.services.impls;

import az.edu.library.library_management.dtos.book.BookCreateDto;
import az.edu.library.library_management.dtos.book.BookResponseDto;
import az.edu.library.library_management.dtos.book.BookUpdateDto;
import az.edu.library.library_management.models.Author;
import az.edu.library.library_management.models.Book;
import az.edu.library.library_management.repositories.AuthorRepository;
import az.edu.library.library_management.repositories.BookRepository;
import az.edu.library.library_management.services.BookService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final ModelMapper modelMapper;

    @Override
    public Page<BookResponseDto> getAllBooks(Pageable pageable) {
        return bookRepository.findAll(pageable)
                .map(this::mapToResponseDto);
    }

    @Override
    public BookResponseDto getBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(()-> new RuntimeException("Book not found with id: " + id));
        return mapToResponseDto(book);
    }

    @Override
    public BookResponseDto createBook(BookCreateDto createDto) {
        Author author = authorRepository.findById(createDto.getAuthorId())
                .orElseThrow(()-> new RuntimeException("Author not found with id: " + createDto.getAuthorId()));

        Book book = modelMapper.map(createDto, Book.class);

        book.setId(null);

        book.setAuthor(author);

        Book savedBook = bookRepository.save(book);
        return mapToResponseDto(savedBook);
    }

    @Override
    public BookResponseDto updateBook(Long id, BookUpdateDto updateDto) {
        Book book = bookRepository.findById(id).orElseThrow(()-> new RuntimeException("Book not found with id: " + id));
        if (updateDto.getAuthorId() != null){
            Author author = authorRepository.findById(updateDto.getAuthorId())
                    .orElseThrow(()-> new RuntimeException("Author not found with id: " + updateDto.getAuthorId()));
            book.setAuthor(author);
        }
        modelMapper.map(updateDto, book);
        Book updatedBook = bookRepository.save(book);
        return mapToResponseDto(updatedBook);
    }

    @Override
    public void deleteBook(Long id) {

        if (!bookRepository.existsById(id)){
            throw  new RuntimeException("Book not found with id: " + id);
        }
        bookRepository.deleteById(id);
    }

    private BookResponseDto mapToResponseDto(Book book){
        BookResponseDto dto = modelMapper.map(book, BookResponseDto.class);
        if (book.getAuthor() != null){
            dto.setAuthorId(book.getAuthor().getId());
        }
        return dto;
    }
}
