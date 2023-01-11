package reachtherecord.springboottoy1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reachtherecord.springboottoy1.repository.JpaMemberRepository;
import reachtherecord.springboottoy1.repository.MemberRepository;
import reachtherecord.springboottoy1.service.MemberService;

@Configuration
public class SpringConfig {

    @PersistenceContext
    private EntityManager em;

    @Bean
    public MemberService memberService() { return new MemberService(memberRepository()); }

    @Bean
    public MemberRepository memberRepository() {
        return new JpaMemberRepository(em);
    }
}
