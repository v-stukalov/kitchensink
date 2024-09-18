package demo.springboot.quickstarts.kitchensink.bootstrap;

import demo.springboot.quickstarts.kitchensink.model.Member;
import demo.springboot.quickstarts.kitchensink.repositories.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DataInitializer implements CommandLineRunner {
    private final MemberRepository memberRepository;

    @Override
    public void run(String... args) {
//        memberRepository.deleteAll();

        Member member0_ = new Member("John Smith", "john.smith@mailinator.com", "2125551212");
        Member member0 = memberRepository.save(member0_);
        System.out.println(member0.getId());

        Member member1_ = new Member("Jane Smith", "jane.smith@mailinator.com", "2588594032");
        Member member1 = memberRepository.save(member1_);
        System.out.println(member1.getId());

        memberRepository.findAll().forEach(member -> {
            System.out.println(member);
        });
    }
}
