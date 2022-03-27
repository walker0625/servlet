package com.servlet.domain.member;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        // given
        Member member = new Member("minwoo", 33);

        // when
        Member savedMember = memberRepository.save(member);

        // then
        Member findedMember = memberRepository.findById(member.getId());
        assertThat(savedMember).isEqualTo(findedMember);
    }

    @Test
    void findAll() {
        //given
        Member member1 = new Member("tester1", 10);
        Member member2 = new Member("tester2", 20);

        memberRepository.save(member1);
        memberRepository.save(member2);

        //when
        List<Member> result = memberRepository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1, member2);
    }

}