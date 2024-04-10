package com.test.project.controller;

import com.test.project.dto.MemberDTO;
import com.test.project.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    @GetMapping("/save")
    public String saveForm(){
        return "save";
    }
    @PostMapping("save")
    public String save(@ModelAttribute MemberDTO memberDTO){
        int saveResult = memberService.save(memberDTO);
        if(saveResult > 0){
            return "login";
        }else{
            return "save";
        }
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/loginForm")
    public String loginForm(@ModelAttribute MemberDTO memberDTO, HttpSession session){
        boolean loginResult = memberService.loginAuth(memberDTO);
        if(loginResult){
            session.setAttribute("userEmail",memberDTO.getUserEmail());
            System.out.println("세션에 저장된 id = " + session.getAttribute("userEmail"));
            return "main";
        }else{
            return "login";
        }

    }
}