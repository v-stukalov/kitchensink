package demo.springboot.quickstarts.kitchensink.service;

import demo.springboot.quickstarts.kitchensink.exception.MemberNotFoundException;
import demo.springboot.quickstarts.kitchensink.model.Member;
import demo.springboot.quickstarts.kitchensink.repositories.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public List<Member> all() {
        return memberRepository.findAll();
    }

    public void save(Member member) {
        memberRepository.save(member);
    }

    public Member findById(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(() -> new MemberNotFoundException(memberId));
    }

    public void deleteById(Long memberId) {
        memberRepository.deleteById(memberId);
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public boolean emailAlreadyExists(String email) {
        return memberRepository.existsByEmail(email);
    }
}
