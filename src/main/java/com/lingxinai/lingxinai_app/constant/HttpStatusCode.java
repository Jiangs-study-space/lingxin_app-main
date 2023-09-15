package com.lingxinai.lingxinai_app.constant;

public enum HttpStatusCode {
    SUCCESS(200, "成功"),
    INVALID_PHONE_NUMBER(1001, "无效手机号"),
    INVALID_VERIFY_CODE(1002, "无效验证码"),

    //注册 1031-1040

    REGISTER_NICK_NAME_EMPTY(1031, "注册时昵称不能为空"),
    REGISTER_SEX_EMPTY(1032,"注册时性别不能为空"),
    REGISTER_BIRTHDAY_EMPTY(1033,"注册时生日不能为空"),
    REGISTER_PHONE_NUMBER_EMPTY(1034,"注册时手机号不能为空"),
    REGISTER_FAILED(1035, "注册失败，请重新尝试"),
    REGISTER_USER_ALREADY_EXIST(1036,"该用户已存在，注册失败"),

    //个人信息 1041-1050
    USER_INFO_USER_NOT_EXIST(1041,"获取信息失败，用户不存在"),

    MODIFY_USER_INFO_USER_ID_EMPTY(1042,"用户id不可为空，信息修改失败"),
    MODIFY_USER_INFO_NICK_NAME_EMPTY(1043,"用户昵称不可为空，信息修改失败"),
    MODIFY_USER_INFO_BIRTHDAY_EMPTY(1044,"用户生日不可为空，信息修改失败"),
    MODIFY_USER_INFO_AVATAR_EMPTY(1045,"用户头像不可为空，信息修改失败"),
    MODIFY_USER_INFO_ADDRESS_EMPTY(1046,"用户地址不可为空，信息修改失败"),

    MODIFY_USER_INFO_FAILED(1047,"用户信息修改失败，请重新尝试"),

    //提交反馈 1051-1060
    ADD_FEEDBACK_USER_ID_EMPTY(1051,"提交反馈时用户id不可为空，提交失败"),
    ADD_FEEDBACK_BUG_TYPE_EMPTY(1052,"提交反馈时问题类型不可为空，提交失败"),
    ADD_FEEDBACK_BUG_DESC_EMPTY(1053,"提交反馈时问题描述不可为空，提交失败"),
    ADD_FEEDBACK_PHONE_NUMBER_EMPTY(1054,"提交反馈时手机号不可为空，提交失败"),
    ADD_FEEDBACK_FAILED(1055,"提交反馈失败，请重新尝试"),
    ;

    public int code;

    public String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    HttpStatusCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
