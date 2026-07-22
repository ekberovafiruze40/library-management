package az.edu.library.library_management.repositories;

import az.edu.library.library_management.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
