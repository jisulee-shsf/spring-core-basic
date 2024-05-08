package course.springcorebasic.member;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();
    MemberRepository memberRepository = new MemoryMemberRepository();

    @Test
    void join() {
        Member member = new Member(1L, "A", Grade.BASIC);
        memberService.join(member);
        Member findMember = memberRepository.findById(member.getId());
        assertThat(member).isEqualTo(findMember);
    }
}
