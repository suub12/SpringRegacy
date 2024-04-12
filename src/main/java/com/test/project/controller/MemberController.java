package com.test.project.controller;

import com.test.project.dto.MemberDTO;
import com.test.project.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor // 의존성 주입
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
    // 유저 리스트 조회
    @GetMapping("/userList")
    public String userList(Model model){
        List<MemberDTO> memberDTOList = memberService.getUserList();
        model.addAttribute("userList", memberDTOList);
        System.out.println(memberDTOList);
        return "userList";
    }
    // 유저 정보 조회
    @GetMapping
    public String userInfo(@RequestParam Long id, Model model){
        MemberDTO userInfo = memberService.getUserInfo(id);
        System.out.println("userInfo :" + userInfo);
        model.addAttribute("member",userInfo);
        return "userInfo";
    }

    @GetMapping("delete")
    public String delete(@RequestParam("id") Long id){
        memberService.delete(id);
        return "redirect:/";
    }
    @GetMapping("update")
    public String update(HttpSession session,Model model){
        Object userMail = session.getAttribute("userEmail");
        MemberDTO userInfo = memberService.getUserDetailInfo(userMail);
        model.addAttribute("member", userInfo);
        return "update";
    }

    @PostMapping("update")
    public String update(@ModelAttribute MemberDTO memberDTO){
        memberService.updateUserInfo(memberDTO);
        System.out.println(memberDTO.getId());
        return "redirect:/member?id="+memberDTO.getId();
    }

}
