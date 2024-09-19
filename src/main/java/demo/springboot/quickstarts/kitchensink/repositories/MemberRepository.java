package demo.springboot.quickstarts.kitchensink.repositories;

import demo.springboot.quickstarts.kitchensink.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Boolean existsByEmail(String email);
    List<Member> findAllByOrderByNameAsc();
}
