package az.edu.library.library_management.dtos.author;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorResponseDto {
    private Long id;
    private String name;
    private String biography;
}
