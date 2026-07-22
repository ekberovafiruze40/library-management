package az.edu.library.library_management.dtos.author;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorCreateDto {

    @NotBlank(message = "Yazarın adı boş ola bilməz")
    @Size(min = 2, max = 100, message = "Yazarın adı 2 ilə 100 simvol arasında olmalıdır")
    private String name;

    @NotBlank(message = "Bioqrafiya boş ola bilməz")
    @Size(min = 10, max = 500, message = "Bioqrafiya 10 ilə 500 simvol arasında olmalıdır")
    private String biography;
}
