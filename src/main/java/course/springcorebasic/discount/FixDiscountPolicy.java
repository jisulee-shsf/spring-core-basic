package course.springcorebasic.discount;

import course.springcorebasic.member.Grade;
import course.springcorebasic.member.Member;
import course.springcorebasic.member.MemberRepository;
import course.springcorebasic.member.MemoryMemberRepository;

public class FixDiscountPolicy implements DiscountPolicy {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        Member findMember = memberRepository.findById(member.getId());
        if (findMember.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
