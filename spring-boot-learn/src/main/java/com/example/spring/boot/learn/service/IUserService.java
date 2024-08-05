package com.example.spring.boot.learn.service;

import com.example.spring.boot.learn.bean.dto.UserDataDto;
import com.example.spring.boot.learn.bean.entity.User;
import com.example.spring.boot.learn.bean.vo.UserDataVo;

import java.util.List;

public interface IUserService {

    List<UserDataDto> getAllUser();

    UserDataDto getUserByIdName(String id, String username);

    Boolean insertUser(UserDataDto user);

    Boolean updateUser(UserDataDto user);

    Boolean deleteUserById(String id);

    Boolean deleteUser(UserDataDto user);


    /** 03 上课新增 */

    /** 获取用户 */
    UserDataVo getUserById(String id);

    /** 获取用户列表 */
    List<UserDataVo> getUserList(int age);



    /** 04 上课新增 */

    /** 更新用户 */
    int updateUserById(User user);


}
