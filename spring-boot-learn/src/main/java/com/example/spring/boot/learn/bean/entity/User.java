package com.example.spring.boot.learn.bean.entity;


import lombok.Getter;
import lombok.Setter;

/**
 * 和数据库字段对应
 * */
@Getter
@Setter
public class User {

    /** 主键ID */
    private Long id;
    /** 姓名 */
    private String name;
    /** 年龄 */
    private int age;
    /** 邮箱 */
    private String email;
    /** 头像 */
    private String avatar;

//    private String username;
//    private String password;

}
