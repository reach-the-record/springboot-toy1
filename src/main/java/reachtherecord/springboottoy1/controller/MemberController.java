package reachtherecord.springboottoy1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import reachtherecord.springboottoy1.repository.MemberRepository;
import reachtherecord.springboottoy1.service.MemberService;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

}
