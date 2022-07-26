package Spring2.exercise.controller;

import Spring2.exercise.member.Member;
import Spring2.exercise.member.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    AppConfig appConfig = new AppConfig();
    MemberRepository memberRepository = appConfig.memberRepository();
    MemberService memberService = appConfig.memberService();
    @GetMapping("/members/join")
    public String join() {
        return "members/joinMember";
    }
    @PostMapping("/members/join")
    public String enroll(MemberForm form) {
        Member member = new Member(form.getName(), form.getCity(), form.getDistance());
        member.setName(form.getName());
        member.setCity(form.getCity());
        member.setDistance(form.getDistance());

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
