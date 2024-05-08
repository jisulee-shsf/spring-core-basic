package course.springcorebasic.discount;

import course.springcorebasic.member.Grade;
import course.springcorebasic.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용된다")
    void vip_o() {
        Member member = new Member(1L, "A", Grade.VIP);
        int discountPrice = discountPolicy.discount(member, 10000);
        assertThat(discountPrice).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 10% 할인이 적용되지 않는다")
    void vip_x() {
        Member member = new Member(2L, "B", Grade.BASIC);
        int discountPrice = discountPolicy.discount(member, 10000);
        assertThat(discountPrice).isNotEqualTo(1000);
    }
}