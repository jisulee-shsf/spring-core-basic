package course.springcorebasic.discount;

import course.springcorebasic.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
