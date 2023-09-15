package com.lingxinai.lingxinai_app.controller;

import com.lingxinai.lingxinai_app.constant.HttpStatusCode;
import com.lingxinai.lingxinai_app.entity.LingxinResponse;
import com.lingxinai.lingxinai_app.entity.User;
import com.lingxinai.lingxinai_app.service.LoginService;
import com.lingxinai.lingxinai_app.utils.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    登陆注册功能
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class LoginController {
    @Autowired
    private LoginService loginService;

    @GetMapping(value="/is_user_exist")
    public LingxinResponse isUserExist(@RequestParam("phone_number") String phone_number) {
        List<User> users = loginService.findUser(phone_number);
        Map<String, Object> data = new HashMap<>();
        boolean is_exist = false;
        User user = null;
        if (users.size() > 0) {
            is_exist = true;
            user = users.get(0);

            data.put("is_user_exist", is_exist);
            data.put("user",user);
            log.info("phone_number: {}, is_exist: {}", phone_number, is_exist);
            return CommonUtils.buildSuccessResponse(data);
        }else{
            data.put("is_user_exist", is_exist);
            data.put("user",user);
            log.info("phone_number: {}, is_exist: {}", phone_number, is_exist);
            return CommonUtils.buildSuccessResponse(data);
        }



    }

    @PostMapping(value="/register")
    public LingxinResponse register(@RequestBody Map<String, Object> params) {
        Map<String, Object> data = new HashMap<>();
        if (!params.containsKey("nick_name")) {
            return CommonUtils.buildFailedResponse(HttpStatusCode.REGISTER_NICK_NAME_EMPTY.getCode(),
                    HttpStatusCode.REGISTER_NICK_NAME_EMPTY.getMessage(), data);
        }
        if (!params.containsKey("sex")){
            return CommonUtils.buildFailedResponse(HttpStatusCode.REGISTER_SEX_EMPTY.getCode(),
                    HttpStatusCode.REGISTER_SEX_EMPTY.getMessage(), data);
        }
        if (!params.containsKey("birthday")){
            return CommonUtils.buildFailedResponse(HttpStatusCode.REGISTER_BIRTHDAY_EMPTY.getCode(),
                    HttpStatusCode.REGISTER_BIRTHDAY_EMPTY.getMessage(), data);
        }
        if (!params.containsKey("phone_number")){
            return CommonUtils.buildFailedResponse(HttpStatusCode.REGISTER_PHONE_NUMBER_EMPTY.getCode(),
                    HttpStatusCode.REGISTER_PHONE_NUMBER_EMPTY.getMessage(), data);
        }
        String phoneNumber = (String) params.get("phone_number");
        //获取手机号后先判断该用户是否已经注册
        List<User> users = loginService.findUser(phoneNumber);
        if (users.size() > 0){
            data.put("user",users.get(0));
            return CommonUtils.buildFailedResponse(HttpStatusCode.REGISTER_USER_ALREADY_EXIST.getCode(),
                    HttpStatusCode.REGISTER_USER_ALREADY_EXIST.getMessage(), data);
        }

        String nickName = (String)params.get("nick_name");
        String sex = (String)params.get("sex");
        String birthday = (String) params.get("birthday");


        //头像和地址可以为空
        String avatar;
        if (!params.containsKey("avatar")){
            avatar = "moren.jpg";
        }else{
            avatar = (String) params.get("avatar");
        }

        String address;
        if (!params.containsKey("address")){
            address = "北京";
        }else{
            address = (String) params.get("address");
        }

        User user = loginService.register(nickName, sex, birthday, phoneNumber, avatar, address);
        if (user != null) {
            data.put("user_id", user.getUserId());
            data.put("nick_name",user.getNickName());
            data.put("age",user.getAge());
            data.put("sex",user.getSex());
            data.put("phone_number",user.getPhoneNumber());
            data.put("avatar",user.getAvatar());
            data.put("address",user.getAddress());
            return CommonUtils.buildSuccessResponse(data);
        } else {
            return CommonUtils.buildFailedResponse(HttpStatusCode.REGISTER_FAILED.getCode(),
                    HttpStatusCode.REGISTER_FAILED.getMessage(), data);
        }
    }
}