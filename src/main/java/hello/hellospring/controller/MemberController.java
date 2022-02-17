package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller //컴포넌트 스캔
public class MemberController {

    private final MemberService memberService;

    @Autowired //생성자 호출시 스프링 컨테이너에 있는 memberService(스프링 빈)을 가져와 연결시켜줌
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
