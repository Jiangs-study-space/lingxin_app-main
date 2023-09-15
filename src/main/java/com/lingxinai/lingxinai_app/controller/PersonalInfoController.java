package com.lingxinai.lingxinai_app.controller;

import com.lingxinai.lingxinai_app.constant.HttpStatusCode;
import com.lingxinai.lingxinai_app.entity.LingxinResponse;
import com.lingxinai.lingxinai_app.entity.User;
import com.lingxinai.lingxinai_app.service.PersonalInfoService;
import com.lingxinai.lingxinai_app.utils.CommonUtils;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    个人信息管理功能
 */
@RestController
@RequestMapping("/userinfo")
@Slf4j
public class PersonalInfoController {
    @Autowired
    private PersonalInfoService personalInfoService;

    @GetMapping(value = "/get_userinfo")
    public LingxinResponse getUserInfo(@RequestParam("user_id")String user_id){
        User user = personalInfoService.findUserById(user_id);
        Map<String,Object> data = new HashMap<>();
        if (user != null ){
            data.put("phone_number",user.getPhoneNumber());
            data.put("user_id",user.getUserId());
            data.put("nick_name",user.getNickName());
            data.put("age",user.getAge());
            data.put("avatar",user.getAvatar());
            data.put("address",user.getAddress());
            return CommonUtils.buildSuccessResponse(data);
        }else{
            return CommonUtils.buildFailedResponse(HttpStatusCode.USER_INFO_USER_NOT_EXIST.getCode(),
                    HttpStatusCode.USER_INFO_USER_NOT_EXIST.getMessage(),data );
        }
    }

    @PostMapping(value = "/modify_userinfo")
    public LingxinResponse modifyUserInfo(@RequestBody Map<String,Object> params){
        Map<String ,Object> data = new HashMap<>();
        System.out.println("进入方法体,,,,");
        if (!params.containsKey("user_id")){
            return CommonUtils.buildFailedResponse(HttpStatusCode.MODIFY_USER_INFO_USER_ID_EMPTY.getCode(),
                    HttpStatusCode.MODIFY_USER_INFO_USER_ID_EMPTY.getMessage(), data);
        }

        if (!params.containsKey("nick_name")){
            return CommonUtils.buildFailedResponse(HttpStatusCode.MODIFY_USER_INFO_NICK_NAME_EMPTY.getCode(),
                    HttpStatusCode.MODIFY_USER_INFO_NICK_NAME_EMPTY.getMessage(), data);
        }

        if (!params.containsKey("birthday")){
            return CommonUtils.buildFailedResponse(HttpStatusCode.MODIFY_USER_INFO_BIRTHDAY_EMPTY.getCode(),
                    HttpStatusCode.MODIFY_USER_INFO_BIRTHDAY_EMPTY.getMessage(),data );
        }

        if (!params.containsKey("avatar")){
            return CommonUtils.buildFailedResponse(HttpStatusCode.MODIFY_USER_INFO_AVATAR_EMPTY.getCode(),
                    HttpStatusCode.MODIFY_USER_INFO_AVATAR_EMPTY.getMessage(), data);
        }

        if (!params.containsKey("address")){
            return CommonUtils.buildFailedResponse(HttpStatusCode.MODIFY_USER_INFO_ADDRESS_EMPTY.getCode(),
                    HttpStatusCode.MODIFY_USER_INFO_ADDRESS_EMPTY.getMessage(), data);
        }

        Integer userId = Integer.valueOf((String) params.get("user_id"));
        String nickName = (String) params.get("nick_name");
        String birthday = (String) params.get("birthday");
        String avatar = (String) params.get("avatar");
        String address = (String) params.get("address");

        User user = personalInfoService.modifyUserInfo(userId,nickName,birthday,avatar,address);
        if (user != null){
            data.put("user_id",user.getUserId());
            data.put("nick_name",user.getNickName());
            data.put("birthday",user.getBirthday());
            data.put("phone_number",user.getPhoneNumber());
            data.put("avatar",user.getAvatar());
            data.put("address",user.getAddress());
            return CommonUtils.buildSuccessResponse(data);
        }else{
            return CommonUtils.buildFailedResponse(HttpStatusCode.MODIFY_USER_INFO_FAILED.getCode(),
                    HttpStatusCode.MODIFY_USER_INFO_FAILED.getMessage(), data);
        }
    }
}
