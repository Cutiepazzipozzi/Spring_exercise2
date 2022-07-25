package Spring2.exercise.controller;

import Spring2.exercise.member.Member;
import Spring2.exercise.member.MemberRepository;
import Spring2.exercise.member.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    MemberRepository memberRepository;
    MemberService memberService;
    @GetMapping("/members/join")
    public String join() {
        return "members/joinMember";
    }
    @PostMapping("/members/join")
    public String enroll(MemberForm form) {
        Member member = new Member(form.getName(), form.getId(), form.getAddress());
        member.setName(form.getName());
        member.setId(form.getId());
        member.setAddress(form.getAddress());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members/list")
    public String list(Model model) {
        List<Member> members = memberService.findAll();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
