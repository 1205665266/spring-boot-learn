package com.example.spring.boot.learn.service.impl;

import com.example.spring.boot.learn.bean.dto.UserDataDto;
import com.example.spring.boot.learn.bean.entity.User;
import com.example.spring.boot.learn.bean.vo.UserDataVo;
import com.example.spring.boot.learn.mapper.UserMapper;
import com.example.spring.boot.learn.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

//@Component
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    public UserServiceImpl() {
        System.out.println("spring 帮我 new 了 UserServiceImpl");
    }

    @Override
    public List<UserDataDto> getAllUser() {
        List<UserDataDto> list = userMapper.getAllUser();
        return list;
    }

    @Override
    public UserDataDto getUserByIdName(String id, String username) {
        UserDataDto user = userMapper.getUserByIdName(id, username);
        return user;
    }

    @Override
    public Boolean insertUser(UserDataDto user) {
        user.setCreateDate(new Date());
        user.setUpdateDate(new Date());
        try {
            int res = userMapper.insertUser(user);
            return res > 0;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public Boolean updateUser(UserDataDto user) {
        user.setUpdateDate(new Date());
        try {
            int res = userMapper.updateUser(user);
            return res > 0;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public Boolean deleteUserById(String id) {
        System.out.println("UserServiceImpl -> deleteUserById id == " + id);
        UserDataDto userDataDto = new UserDataDto();
        userDataDto.setId(Integer.parseInt(id));
        userMapper.deleteUser(userDataDto);
        return true;
    }

    @Override
    public Boolean deleteUser(UserDataDto user) {
        System.out.println("UserServiceImpl -> user == " + user.toString());
        return true;
    }


    /** 03 上课新增 */

    /** 获取用户 */
    public UserDataVo getUserById(String id) {
        return userMapper.getUserById(id);
    }

    /** 获取用户列表 */
    @Override
    public List<UserDataVo> getUserList(int age) {
        return userMapper.getUserList(age);
    }


    /** 04 上课新增 */

    /** 更新用户 */
    @Override
    public int updateUserById(User user) {
        return userMapper.updateUserById(user);
    }
}
