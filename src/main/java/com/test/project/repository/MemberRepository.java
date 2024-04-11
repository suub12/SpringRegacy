package com.test.project.repository;

import com.test.project.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final SqlSessionTemplate sql;
    public int save(MemberDTO memberDTO){
        return sql.insert("Member.save", memberDTO);
    }

    public MemberDTO login(MemberDTO memberDTO){
        return sql.selectOne("Member.login", memberDTO);
    }

    public List<MemberDTO> getUserList(){
        return sql.selectList("Member.userList");
    }

    public MemberDTO getUserInfo(Long id){
        return sql.selectOne("Member.userInfo", id);
    }

    public void delete(Long id){
        sql.delete("Member.delete",id);
    }
}
