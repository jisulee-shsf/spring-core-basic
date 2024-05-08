package course.springcorebasic.order;

import course.springcorebasic.discount.DiscountPolicy;
import course.springcorebasic.discount.FixDiscountPolicy;
import course.springcorebasic.member.Member;
import course.springcorebasic.member.MemberRepository;
import course.springcorebasic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
