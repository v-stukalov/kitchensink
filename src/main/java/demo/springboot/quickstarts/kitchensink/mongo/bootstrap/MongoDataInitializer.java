package demo.springboot.quickstarts.kitchensink.mongo.bootstrap;

import demo.springboot.quickstarts.kitchensink.mongo.model.MongoMember;
import demo.springboot.quickstarts.kitchensink.mongo.repositories.MongoMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class MongoDataInitializer implements CommandLineRunner {
    private final MongoMemberRepository repository;

    @Override
    public void run(String... args) {
//        repository.deleteAll();
        repository.save(MongoMember.builder()
                .id(UUID.randomUUID().toString())
                .name("Wayne Rigsby")
                .email("wrigsby@cbi.gov")
                .phoneNumber("9407074997")
                .build());
        repository.save(MongoMember.builder()
                .id(UUID.randomUUID().toString())
                .name("Grace Van Pelt")
                .email("gvanpelt@cbi.gov")
                .phoneNumber("4699093448")
                .build());

        System.out.println("members found with findAll():");
        for (MongoMember member : repository.findAll()) {
            System.out.println(member);
        }

        System.out.println("member found by name");
        System.out.println(repository.findByName("Grace Van Pelt"));
    }
}
