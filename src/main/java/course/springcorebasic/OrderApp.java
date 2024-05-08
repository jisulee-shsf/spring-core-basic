package course.springcorebasic;

import course.springcorebasic.member.Grade;
import course.springcorebasic.member.Member;
import course.springcorebasic.member.MemberService;
import course.springcorebasic.order.Order;
import course.springcorebasic.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "A", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "B", 30000);
        System.out.println("order = " + order);
    }
}
