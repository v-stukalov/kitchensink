package demo.springboot.quickstarts.kitchensink.controller;

import demo.springboot.quickstarts.kitchensink.model.Member;
import demo.springboot.quickstarts.kitchensink.service.MemberService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/members")
public class MemberRestController {
    private final MemberService memberService;

    @GetMapping
    public List<Member> findAllMembers() {
        return memberService.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            headers = {"Content-Type=application/json", "Accept=application/json"})
    public void addMember(@RequestBody Member newMember, HttpServletResponse response) {
        memberService.save(newMember);
        response.setStatus(HttpServletResponse.SC_CREATED);
    }

    @GetMapping("/{id}")
    public Member findMemberById(@PathVariable Long id) {
        return memberService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void removeMember(@PathVariable Long id, HttpServletResponse response) {
        this.memberService.deleteById(id);
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }
}
