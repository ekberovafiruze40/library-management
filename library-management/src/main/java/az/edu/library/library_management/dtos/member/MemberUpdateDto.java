package az.edu.library.library_management.dtos.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberUpdateDto {
    private String fullName;
    private String email;
}
