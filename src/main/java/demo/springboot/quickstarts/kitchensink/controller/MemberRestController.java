package demo.springboot.quickstarts.kitchensink.controller;

import demo.springboot.quickstarts.kitchensink.exception.MemberNotFoundException;
import demo.springboot.quickstarts.kitchensink.model.Member;
import demo.springboot.quickstarts.kitchensink.repositories.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/members")
public class MemberRestController {
    private final MemberRepository repository;

    @GetMapping
    public List<Member> findAllMembers() {
        return repository.findAll();
    }

    @PostMapping
    public Member saveMember(@RequestBody Member member) {
        return repository.save(member);
    }

    @GetMapping("/{id}")
    public Member findMemberById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException(id));
    }

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
