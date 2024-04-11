package com.test.project.service;

import com.test.project.dto.MemberDTO;
import com.test.project.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public int save(MemberDTO memberDTO){
        return memberRepository.save(memberDTO);
    }

    public boolean loginAuth(MemberDTO memberDTO){
        MemberDTO loginMember = memberRepository.login(memberDTO);
        if(loginMember != null){
            return true;
        }else{
            return false;
        }
    }

    public List<MemberDTO> getUserList(){
        return memberRepository.getUserList();
    }

    public MemberDTO getUserInfo(Long id){
        return memberRepository.getUserInfo(id);
    }
    public void delete(Long id){
        memberRepository.delete(id);
    }


}
