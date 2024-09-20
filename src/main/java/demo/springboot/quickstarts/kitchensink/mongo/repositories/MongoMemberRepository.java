package demo.springboot.quickstarts.kitchensink.mongo.repositories;

import demo.springboot.quickstarts.kitchensink.mongo.model.MongoMember;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableMongoRepositories(basePackageClasses = MongoMemberRepository.class)
@Repository
public interface MongoMemberRepository extends MongoRepository<MongoMember, String> {
    List<MongoMember> findByName(final String name);
}
