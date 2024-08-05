package com.example.spring.boot.learn.mapper;

import com.example.spring.boot.learn.bean.dto.UserDataDto;
import com.example.spring.boot.learn.bean.entity.User;
import com.example.spring.boot.learn.bean.vo.UserDataVo;
import org.apache.ibatis.annotations.*;


import java.util.List;

@Mapper
public interface UserMapper {


    @Select("SELECT id, username, password, email, nickName, phone, age, createDate, updateDate FROM tb_UserData")
    public List<UserDataDto> getAllUser();

    @Select("SELECT id, username, password, email, nickName, phone, age, createDate, updateDate " +
            "FROM tb_UserData t where t.id = #{id} and t.username = #{username}")
    public UserDataDto getUserByIdName(@Param("id") String id, @Param("username") String username);


    @Insert("INSERT INTO tb_UserData (id, username, password, email, nickName, phone, age, createDate, updateDate) " +
            "VALUES (#{id}, #{username}, #{password}, #{email}, #{nickName}, #{phone}, #{age}, #{createDate}, #{updateDate})")
    public int insertUser(UserDataDto user);

    @Update("UPDATE tb_UserData SET password = #{password}, updateDate = #{updateDate} " +
            "WHERE id = #{id} AND username = #{username}")
    public int updateUser(UserDataDto user);



    // 这样就是直接使用了UserDataDto对象的id：#{id}
//    @Delete("Delete from tb_UserData t where t.id = #{id}")
//    public void deleteUser(UserDataDto user);

    // 使用@Param注解给UserDataDto对象设置别名user 获取id属性：#{user.id}
    @Delete("Delete from tb_UserData t where t.id = #{user.id}")
    public void deleteUser(@Param("user") UserDataDto user);



    /** 03 上课新增 */

    /**
     * @Select("SELECT * FROM user")
     * // @Update("UPDATE user SET name = 'Nianhua' WHERE ***")
     * // @Delete("DELETE FROM ")
     * // @Insert("INSERT INTO `user` (id, name, age, email, avatar) VALUE ()")
     *     List<UserDataVO> getUserList(UserDataDTO requestDto);
     * */

    /** 获取用户 */
//    @Select("SELECT * FROM user u where u.id = #{id}")
    public UserDataVo getUserById(@Param("id") String id);

    /** 获取用户列表 */
    @Select("SELECT * FROM user u where u.age > #{age}")
    public List<UserDataVo> getUserList(@Param("age") int age);


    /** 04 上课新增 */
//    @Update("UPDATE user SET name = #{user.name} where id = #{user.id}")
    public int updateUserById(@Param("user") User user);

}
