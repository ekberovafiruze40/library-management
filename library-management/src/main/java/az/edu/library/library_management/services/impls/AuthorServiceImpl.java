package az.edu.library.library_management.services.impls;

import az.edu.library.library_management.dtos.author.AuthorCreateDto;
import az.edu.library.library_management.dtos.author.AuthorResponseDto;
import az.edu.library.library_management.dtos.author.AuthorUpdateDto;
import az.edu.library.library_management.models.Author;
import az.edu.library.library_management.repositories.AuthorRepository;
import az.edu.library.library_management.services.AuthorService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<AuthorResponseDto> getAllAuthors() {
        return authorRepository.findAll().stream()
                .map(author -> modelMapper.map(author, AuthorResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public AuthorResponseDto getAuthorById(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Author not found with id: " + id));
        return modelMapper.map(author, AuthorResponseDto.class);
    }

    @Override
    public AuthorResponseDto createAuthor(AuthorCreateDto createDto) {
        Author author = modelMapper.map(createDto, Author.class);
        Author savedAuthor = authorRepository.save(author);
        return modelMapper.map(savedAuthor, AuthorResponseDto.class);
    }

    @Override
    public AuthorResponseDto updateAuthor(Long id, AuthorUpdateDto updateDto) {
        Author author = authorRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Author not found with id " + id));

        modelMapper.map(updateDto, author);
        Author updatedAuthor = authorRepository.save(author);
        return modelMapper.map(updatedAuthor, AuthorResponseDto.class);
    }

    @Override
    public void deleteAuthor(Long id) {

        if (!authorRepository.existsById(id)){
            throw new RuntimeException("Author not found with id: " + id);
        }

        authorRepository.deleteById(id);
    }
}
