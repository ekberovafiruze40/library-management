package az.edu.library.library_management.controllers;

import az.edu.library.library_management.dtos.author.AuthorCreateDto;
import az.edu.library.library_management.dtos.author.AuthorResponseDto;
import az.edu.library.library_management.dtos.author.AuthorUpdateDto;
import az.edu.library.library_management.services.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping
    public ResponseEntity<List<AuthorResponseDto>> getAllAuthors(){
        List<AuthorResponseDto> authors = authorService.getAllAuthors();
        return ResponseEntity.ok(authors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponseDto> getAuthorById(@PathVariable Long id){
        AuthorResponseDto author = authorService.getAuthorById(id);
        return ResponseEntity.ok(author);
    }

    @PostMapping
    public ResponseEntity<AuthorResponseDto> createAuthor(@Valid  @RequestBody AuthorCreateDto createDto){
        AuthorResponseDto createdAuthor = authorService.createAuthor(createDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAuthor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorResponseDto> updateAuthor (@PathVariable Long id,
                                                           @RequestBody AuthorUpdateDto updateDto){
        AuthorResponseDto updatedAuthor = authorService.updateAuthor(id, updateDto);
        return ResponseEntity.ok(updatedAuthor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AuthorResponseDto> deleteAuthor (@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }
}
