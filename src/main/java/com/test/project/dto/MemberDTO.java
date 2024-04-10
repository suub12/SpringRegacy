package com.test.project.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDTO {
    private long id;
    private String userName;
    private String userEmail;
    private String userPw;
    private int userAge;
    private String userPhoneNumber;

}
