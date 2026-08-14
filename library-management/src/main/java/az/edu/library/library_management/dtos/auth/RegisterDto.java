package az.edu.library.library_management.dtos.auth;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {

    @NotEmpty(message = "Username cannot be empty.")
    @Size(min = 3, max = 50, message = "Username must between 3 and 50 characters.")
    private String  username;

    @NotEmpty(message = "Password cannot be emty.")
    @Pattern(
            regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,})",
            message = "Password must be at least 8 characters long, and contain a digit, lowercase, uppercase, and special character."
    )
    private String password;

    @NotEmpty(message = "Confirm password cannot be empty.")
    private String confirmPassword;

    @AssertTrue(message = "Passwords do not match.")
    public boolean isPasswordsMatching() {
        return password != null && password.equals(confirmPassword);
    }

}
