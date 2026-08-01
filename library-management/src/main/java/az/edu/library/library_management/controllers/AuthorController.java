package az.edu.library.library_management.controllers;

import az.edu.library.library_management.dtos.author.AuthorCreateDto;
import az.edu.library.library_management.dtos.author.AuthorResponseDto;
import az.edu.library.library_management.dtos.author.AuthorUpdateDto;
import az.edu.library.library_management.services.AuthorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
@Tag(name = "Author Management",description = "API endpoints for author management")
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping
    @Operation(summary = "Get all authors", description = "Retrieves a list of all registered authors")
    @ApiResponse(responseCode = "200", description = "Author list successfully retrieved")
    public ResponseEntity<List<AuthorResponseDto>> getAllAuthors(){
        List<AuthorResponseDto> authors = authorService.getAllAuthors();
        return ResponseEntity.ok(authors);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get author by ID", description = "Retrieves author details by their unique ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Author successfully found"),
            @ApiResponse(responseCode = "404", description = "Author not found with the given ID")
    })
    public ResponseEntity<AuthorResponseDto> getAuthorById(@PathVariable Long id){
        AuthorResponseDto author = authorService.getAuthorById(id);
        return ResponseEntity.ok(author);
    }

    @PostMapping
    @Operation(summary = "Create a new author", description = "Adds a new author to the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Author successfully created"),
            @ApiResponse(responseCode = "400", description = "Invalid or missing input data")
    })
    public ResponseEntity<AuthorResponseDto> createAuthor(@Valid  @RequestBody AuthorCreateDto createDto){
        AuthorResponseDto createdAuthor = authorService.createAuthor(createDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAuthor);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an author", description = "Updates an existing author's information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Author successfully updated"),
            @ApiResponse(responseCode = "404", description = "Author not found")
    })
    public ResponseEntity<AuthorResponseDto> updateAuthor (@PathVariable Long id,
                                                           @RequestBody AuthorUpdateDto updateDto){
        AuthorResponseDto updatedAuthor = authorService.updateAuthor(id, updateDto);
        return ResponseEntity.ok(updatedAuthor);
    }

    @DeleteMapping("/{id}")
    @Operation(summary ="Delete an author", description = "Removes an author from the system by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Author successfully deleted"),
            @ApiResponse(responseCode = "404", description = "Author not found")
    })
    public ResponseEntity<AuthorResponseDto> deleteAuthor (@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }
}
