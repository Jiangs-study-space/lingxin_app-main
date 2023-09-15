package com.lingxinai.lingxinai_app.entity;

import java.util.Map;

public class LingxinResponse {
    public int code;
    public String message;
    public Map<String, Object> data;

    public LingxinResponse(int code, String message, Map<String, Object> data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
