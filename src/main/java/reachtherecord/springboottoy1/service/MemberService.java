package reachtherecord.springboottoy1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reachtherecord.springboottoy1.domain.Member;
import reachtherecord.springboottoy1.repository.MemberRepository;
import reachtherecord.springboottoy1.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private MemberRepository memberRepository;
    @Autowired
    public MemberService(MemberRepository repo) {
        memberRepository = repo;
    }

    /*
    * 회원 가입
    * */
    public Long join(Member member) {
        validateDuplicatedMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicatedMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOneById(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
