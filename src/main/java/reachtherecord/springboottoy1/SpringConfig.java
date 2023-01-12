package reachtherecord.springboottoy1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reachtherecord.springboottoy1.aop.TimeTraceAop;
import reachtherecord.springboottoy1.repository.JpaMemberRepository;
import reachtherecord.springboottoy1.repository.MemberRepository;
import reachtherecord.springboottoy1.service.MemberService;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;
    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @PersistenceContext
    private EntityManager em;

    @Bean
    public MemberService memberService() { return new MemberService(memberRepository); }

//    @Bean
//    public TimeTraceAop timeTraceAop() {
//        return new TimeTraceAop();
//    }
//    @Bean
//    public MemberRepository memberRepository() {
//        return new JpaMemberRepository(em);
//    }
}
