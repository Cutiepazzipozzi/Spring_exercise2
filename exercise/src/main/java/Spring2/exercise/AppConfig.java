package Spring2.exercise;

import Spring2.exercise.member.MemberRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberRepository memberRepository() {
        return new MemberRepositoryImpl();
    }
}
