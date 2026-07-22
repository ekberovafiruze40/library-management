package az.edu.library.library_management.services;

import az.edu.library.library_management.dtos.author.AuthorCreateDto;
import az.edu.library.library_management.dtos.author.AuthorResponseDto;
import az.edu.library.library_management.dtos.author.AuthorUpdateDto;

import java.util.List;

public interface AuthorService {
    List<AuthorResponseDto> getAllAuthors();
    AuthorResponseDto getAuthorById(Long id);
    AuthorResponseDto createAuthor(AuthorCreateDto createDto);
    AuthorResponseDto updateAuthor(Long id, AuthorUpdateDto updateDto);
    void deleteAuthor(Long id);
}
