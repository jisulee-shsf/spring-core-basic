package course.springcorebasic.member;

import course.springcorebasic.AppConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        Member member = new Member(1L, "A", Grade.BASIC);
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        assertThat(member).isEqualTo(findMember);
    }
}
