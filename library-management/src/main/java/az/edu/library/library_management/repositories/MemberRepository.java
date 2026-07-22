package az.edu.library.library_management.repositories;

import az.edu.library.library_management.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
