package reachtherecord.springboottoy1.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import reachtherecord.springboottoy1.domain.Member;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repo = new MemoryMemberRepository();
    @AfterEach
    public void afterEach() {
        repo.clearStore();
    }
    @Test
    void save() {
        Member member = new Member();
        member.setName("spring");
        repo.save(member);
        Member result = repo.findById(member.getId()).get();
        assertThat(result).isEqualTo(member);
    }

    @Test
    void findById() {
    }

    @Test
    void findByName() {
        Member member1 = new Member();
        member1.setName("member1");
        repo.save(member1);
        Member member2 = new Member();
        member2.setName("member2");
        repo.save(member2);

        Member result = repo.findByName(member1.getName()).get();

        assertThat(member1).isEqualTo(result);
    }

    @Test
    void findAll() {
        Member mem1 = new Member();
        mem1.setName("member1");
        repo.save(mem1);
        Member mem2 = new Member();
        mem2.setName("member2");
        repo.save(mem2);

        List<Member> result = repo.findAll();
        assertThat(2).isEqualTo(result.size());
    }
}