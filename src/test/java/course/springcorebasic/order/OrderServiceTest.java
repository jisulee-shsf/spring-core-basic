package course.springcorebasic.order;

import course.springcorebasic.member.Grade;
import course.springcorebasic.member.Member;
import course.springcorebasic.member.MemberService;
import course.springcorebasic.member.MemberServiceImpl;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "A", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "B", 10000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
