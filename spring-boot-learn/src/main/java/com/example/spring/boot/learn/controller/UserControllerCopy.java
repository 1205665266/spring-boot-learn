package com.example.spring.boot.learn.controller;

import com.example.spring.boot.learn.bean.dto.LoginResponse;
import com.example.spring.boot.learn.bean.dto.UserDataDto;
import com.example.spring.boot.learn.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/copy/api")
public class UserControllerCopy {

    @Autowired
    private IUserService userService;


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestParam String username, @RequestParam String password, @RequestHeader(value = "Authorization", required = false) String headerToken){
        // 打印获取到的 token
        System.out.println("login Header Token: " + headerToken);
        if (username != null && !username.isEmpty() && password != null && !password.isEmpty()) {
            LoginResponse response = new LoginResponse();
            response.setMessage("Login successful");
            response.setCode(200);
            LoginResponse.Body body = new LoginResponse.Body();
            body.setStatus("200");
            // 创建一个Random对象
            Random random = new Random();
            // 生成一个0到99之间的随机整数
            int randomNumber = random.nextInt(100);
            String token = "dummy-token---" + randomNumber;
            body.setToken(token);
            response.setBody(body);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(401).body(new LoginResponse("Invalid username or password", 401));
        }
    }

    /**
     * Restful Api 规范：GET 请求 "/api/user/list/all"
     * 无参
     * @return { @link String}
     * */
    @GetMapping("/user/list/all")
    public String getUserListAll(@RequestHeader(value = "Authorization", required = false) String headerToken){
        // 打印获取到的 token
        System.out.println("getUserListAll Token: " + headerToken);
        List<UserDataDto> list = userService.getAllUser();
        System.out.println("getUser list =" + list.size());
        return "get getUserListAll =" + list.size();
    }

    /**
     * Restful Api 规范：GET 请求 "/api/user/123"
     * 获取用户详情：请求地址中携带参数使用PathVariable
     * @return { @link String}
     * */
    @GetMapping("/user/{id}")
    public String getUserId(@PathVariable String id){
        return "get User " + id;
    }

    /**
     * Restful Api 规范：GET 请求 "/api/user/123"
     * 获取用户详情：param中传参
     * @return { @link String}
     * */
    @GetMapping("/user/by/id/username")
    public UserDataDto getUserByIdName(@RequestParam String id, @RequestParam String username, @RequestParam(required = false) String password,  @RequestHeader(value = "Authorization", required = false) String headerToken){
        // 打印获取到的 token
        System.out.println("getUserByIdName Token: " + headerToken);
        System.out.println("get getUserByIdName id + username = " + id + username);
        System.out.println("get getUserByIdName password = " + password);
        UserDataDto userDataDto = userService.getUserByIdName(id, username);
        return userDataDto;
    }

    /**
     * Restful Api 规范：POST 请求 "/api/user/add"
     * 新增用户：接收参数是dto使用RequestBody
     * @return { @link UserDataDto}
     * */
    @PostMapping("/user/add")
    public UserDataDto addUser(@RequestBody UserDataDto dto){
        System.out.println("新增用户 /user/add  start");
        List<UserDataDto> list = userService.getAllUser();
        dto.setId(list.size()+1);
        // 设置密码
        // 创建一个Random对象
        Random random = new Random();
        // 生成一个0到99之间的随机整数
        int randomNumber = random.nextInt(100);
        dto.setPassword(dto.getPassword() + randomNumber);
        Boolean result = userService.insertUser(dto);
        System.out.println("新增用户 /user/add  end");
        if (result) {
            System.out.println("新增用户 /user/add  成功");
            return dto;
        }
        System.out.println("新增用户 /user/add  失败");
        return null;
    }

    /**
     * Restful Api 规范：POST 请求 "/api/user/add"
     * 新增用户：接收参数是 基本数据类型 使用 RequestParam
     * @return { @link UserDataDto}
     * */
    @PostMapping("/user/add/test/param")
    public String postUserTestParam(@RequestParam String id){
        return "RequestParam传参postUserTestParam =" + id;
    }

    @PostMapping("/user/add/test/body")
    public String postUserTestBody(@RequestBody String id){
        return "RequestBody传参postUserTestBody =" + id;
    }


    /**
     * Restful Api 规范：PUT 请求 "/api/user/update"
     * 更新用户详情：接收参数是dto使用RequestBody
     * @return { @link UserDataDto}
     * */
    @PutMapping("/user/update")
    public UserDataDto putUser(@RequestBody UserDataDto dto) {
        // 延时 5 秒
        try {
            Thread.sleep(3000); // 5000 毫秒 = 3 秒
        } catch (InterruptedException ignored) {

        }

        // 设置密码
        // 创建一个Random对象
        Random random = new Random();
        // 生成一个0到99之间的随机整数
        int randomNumber = random.nextInt(10000);
        if (dto.getPassword() == null || dto.getPassword().isEmpty()) {
            dto.setPassword(randomNumber + "");
        }
        boolean result = userService.updateUser(dto);
        if (result) {
            System.out.println("更新用户 /user/update  成功");
            return dto;
        }
        System.out.println("更新用户 /user/update  失败");
        return null;
    }

    /**
     * Restful Api 规范：DELETE 请求 "/api/user/11111"
     * 根据id删除用户：在请求地址中携带参数使用PathVariable
     * @return { @link String}
     * */
    @DeleteMapping("/user/{id}")
    public String deleteUserById(@PathVariable String id){
        return "deleteUserById = " + id;
    }

    /**
     * Restful Api 规范：DELETE 请求 "/api/user/delete/list"
     * 批量删除用户：接收参数是 基本数据类型 使用 RequestParam
     * @return { @link String}
     * */
    @DeleteMapping("/user/delete/list")
    public String deleteUser(@RequestParam List<String> idList){
        System.out.println(idList);
        String str = String.join("-", idList);
        return "idList = " + str;
    }

    /**
     * Restful Api 规范：DELETE 请求 "/api/usertest"
     * GET请求写法：不常用；
     * @return { @link String}
     * */
    @RequestMapping(value = "/usertest", method = RequestMethod.GET)
    public String getTest(){
        return "getTest";
    }

    /**
     * Restful Api 规范：DELETE 请求 "/api/user/delete/id"
     * 根据id删除用户：接收参数是 基本数据类型 使用 RequestParam
     * @return { @link String}
     * */
    @DeleteMapping("/user/delete/id")
    public String deleteUserId(@RequestParam String id){
        userService.deleteUserById(id);
        return "deleteTest id =" + id;
    }

    @PostMapping("/user/setting/params")
    public Map<String, Object> settingParams(@RequestParam Map<String, Object> map){
        System.out.println("settingParams");
        System.out.println(map);
        return map;
    }




}
