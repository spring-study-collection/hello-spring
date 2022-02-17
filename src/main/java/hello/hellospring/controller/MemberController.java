package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller //컴포넌트 스캔
public class MemberController {

    private final MemberService memberService;

    //1. DI (생성자 주입)
    @Autowired //생성자 호출시 스프링 컨테이너에 있는 memberService(스프링 빈)을 가져와 연결시켜줌
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    //2. DI (필드 주입)
    //@Autowired private MemberService memberService;

    //3. DI (setter 주입)
    //private MemberService memberService;

    //@Autowired
    //public void setMemberService(MemberService memberService) {
    //    this.memberService = memberService;
    //}

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
