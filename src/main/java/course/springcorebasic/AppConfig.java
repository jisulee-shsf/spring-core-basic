package course.springcorebasic;

import course.springcorebasic.discount.DiscountPolicy;
import course.springcorebasic.discount.RateDiscountPolicy;
import course.springcorebasic.member.MemberRepository;
import course.springcorebasic.member.MemberService;
import course.springcorebasic.member.MemberServiceImpl;
import course.springcorebasic.member.MemoryMemberRepository;
import course.springcorebasic.order.OrderService;
import course.springcorebasic.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
