package com.lingxinai.lingxinai_app.utils;

import com.lingxinai.lingxinai_app.constant.HttpStatusCode;
import com.lingxinai.lingxinai_app.entity.LingxinResponse;

import java.util.Map;

public class CommonUtils {
    public static LingxinResponse buildSuccessResponse(Map<String, Object> data) {
        return new LingxinResponse(HttpStatusCode.SUCCESS.getCode(),
                HttpStatusCode.SUCCESS.getMessage(),
                data);
    }

    public static LingxinResponse buildFailedResponse(int code, String message, Map<String, Object> data) {
        return new LingxinResponse(code, message, data);
    }
}
