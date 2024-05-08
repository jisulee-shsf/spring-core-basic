package course.springcorebasic;

import course.springcorebasic.discount.DiscountPolicy;
import course.springcorebasic.discount.FixDiscountPolicy;
import course.springcorebasic.member.MemberRepository;
import course.springcorebasic.member.MemberService;
import course.springcorebasic.member.MemberServiceImpl;
import course.springcorebasic.member.MemoryMemberRepository;
import course.springcorebasic.order.OrderService;
import course.springcorebasic.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
