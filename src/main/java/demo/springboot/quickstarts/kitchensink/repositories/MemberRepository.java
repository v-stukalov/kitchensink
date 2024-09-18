package demo.springboot.quickstarts.kitchensink.repositories;

import demo.springboot.quickstarts.kitchensink.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
