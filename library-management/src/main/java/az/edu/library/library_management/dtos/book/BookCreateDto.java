package az.edu.library.library_management.dtos.book;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookCreateDto {
    @NotBlank(message = "Kitab adı boş ola bilməz")
    private String title;

    @NotBlank(message = "ISBN boş ola bilməz")
    private String isbn;

    @NotNull(message = "Nəşr ili qeyd olunmalıdır")
    private Integer publicationYear;

    @NotNull(message = "Yazar ID-si qeyd olunmalıdır")
    private Long authorId;
}
