package com.example.spring.boot.learn.bean.vo;


import lombok.Getter;
import lombok.Setter;

/**
 * 后端返回前端数据
 * */

@Getter
@Setter
public class UserDataVo {

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
