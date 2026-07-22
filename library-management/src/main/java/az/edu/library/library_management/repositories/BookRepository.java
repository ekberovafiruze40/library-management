package az.edu.library.library_management.repositories;

import az.edu.library.library_management.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
