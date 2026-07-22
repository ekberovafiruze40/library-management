package az.edu.library.library_management.dtos.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberResponseDto {
    private Long id;
    private String fullName;
    private String email;
    private LocalDate registeredDate;
}
