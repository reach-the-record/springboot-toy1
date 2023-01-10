package reachtherecord.springboottoy1.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reachtherecord.springboottoy1.domain.Member;
import reachtherecord.springboottoy1.repository.MemoryMemberRepository;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemoryMemberRepository repo;
    MemberService memberService;
    @BeforeEach
    public void beforeEach() {
        repo = new MemoryMemberRepository();
        memberService = new MemberService(repo);
    }
    @AfterEach
    public void afterEach() {
      repo.clearStore();
    }

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