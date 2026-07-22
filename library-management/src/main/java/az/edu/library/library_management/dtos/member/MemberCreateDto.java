package az.edu.library.library_management.dtos.member;

import jakarta.validation.constraints.Email;
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
public class MemberCreateDto {

    @NotBlank(message = "Ad və soyad boş ola bilməz")
    @Size(min = 3, max = 100, message = "Ad və soyad 3 ilə 100 simvol arasında olmalıdır")
    private String fullName;

    @NotBlank(message = "E-poçt ünvanı boş ola bilməz")
    @Email(message = "Düzgün e-poçt ünvanı daxil edin")
    private String email;
}
