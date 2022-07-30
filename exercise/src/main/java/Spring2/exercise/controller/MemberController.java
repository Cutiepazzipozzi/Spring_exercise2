package Spring2.exercise.controller;

import Spring2.exercise.member.Member;
import Spring2.exercise.member.MemberRepository;
import Spring2.exercise.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    @GetMapping("/members/join")
    public String join(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "members/joinMember";
    }
    @PostMapping("/members/join")
    public String enroll(@Valid MemberForm form, BindingResult result) {

        //binding result 함 찾아보기
     //원래 코드 보면서 넣어본 것 일단,.,.
//        if(result.hasErrors()) {
//            return "members/joinMember";
//        }

        Member member = new Member();
        member.setName(form.getName());
        member.setCity(form.getCity());

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
