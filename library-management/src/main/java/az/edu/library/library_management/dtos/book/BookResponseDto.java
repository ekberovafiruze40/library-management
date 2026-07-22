package az.edu.library.library_management.dtos.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseDto {
    private Long id;
    private String title;
    private String isbn;
    private int publicationYear;
    private Long authorId;
}
