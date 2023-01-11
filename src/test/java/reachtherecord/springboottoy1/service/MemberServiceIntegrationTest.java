package reachtherecord.springboottoy1.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import reachtherecord.springboottoy1.domain.Member;
import reachtherecord.springboottoy1.repository.MemberRepository;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {
    @Autowired
    MemberRepository repo;
    @Autowired MemberService memberService;

    @Test
    void join() {
        Member member = new Member();
        member.setName("hello1");

        Long saveId = memberService.join(member);
        Member findMember = memberService.findOneById(saveId).get();
        Assertions.assertThat(member).isEqualTo(findMember);
    }

    @Test
    void duplicatedMember() {
        Member member = new Member();
        member.setName("Spring");

        Member member2 = new Member();
        member2.setName("Spring");

        memberService.join(member);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOneById() {
    }
}