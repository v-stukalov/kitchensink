package demo.springboot.quickstarts.kitchensink.mongo.controller;

import demo.springboot.quickstarts.kitchensink.mongo.model.MongoMember;
import demo.springboot.quickstarts.kitchensink.mongo.repositories.MongoMemberRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mongo")
public class MongoMemberRestController {

    private final MongoMemberRepository mongoMemberRepository;

    public MongoMemberRestController(final MongoMemberRepository mongoMemberRepository) {
        this.mongoMemberRepository = mongoMemberRepository;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody final MongoMember mongoMember) {
        return ResponseEntity.ok(mongoMemberRepository.save(mongoMember));
    }

    @GetMapping
    public ResponseEntity<?> listRiceproduction() {
        return ResponseEntity.ok(mongoMemberRepository.findAll());
    }

    @GetMapping("/name/{memberName}")
    public ResponseEntity<?> findByName(@PathVariable final String memberName) {
        return ResponseEntity.ok(mongoMemberRepository.findByName(memberName));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable final String id) {
        return ResponseEntity.ok(mongoMemberRepository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable final String id) {
        mongoMemberRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
