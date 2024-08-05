package com.example.spring.boot.learn.bean.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 前端传给后端数据
 * */

@Setter
@Getter
public class UserDataDto {

    private long id;
    private String username;
    private String password;
    private String email;
    private String nickName;
    private String phone;
    private int age;
    private Date createDate;
    private Date updateDate;


    /** 姓名 */
    private String name;
    /** 头像 */
    private String avatar;

}
