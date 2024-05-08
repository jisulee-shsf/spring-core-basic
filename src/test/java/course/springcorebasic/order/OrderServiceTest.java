package course.springcorebasic.order;

import course.springcorebasic.AppConfig;
import course.springcorebasic.member.Grade;
import course.springcorebasic.member.Member;
import course.springcorebasic.member.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "A", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "B", 10000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
