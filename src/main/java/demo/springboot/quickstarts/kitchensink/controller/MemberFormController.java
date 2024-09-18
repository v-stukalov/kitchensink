package demo.springboot.quickstarts.kitchensink.controller;

import demo.springboot.quickstarts.kitchensink.model.Member;
import demo.springboot.quickstarts.kitchensink.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class MemberFormController {
    private final MemberService memberService;

    @GetMapping
    public String showMembersForm(Model model) {
        model.addAttribute("members", memberService.findAll());
        return "members";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model member) {
        member.addAttribute("member", new Member());
        return "register";
    }

    @PostMapping("/register")
    public String registerMember(
            @Valid @ModelAttribute("member") Member member,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            return "register";
        }
        memberService.save(member);
        model.addAttribute("members", memberService.findAll());
        return "members";
    }
}
