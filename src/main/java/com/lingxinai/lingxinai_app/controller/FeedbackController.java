package com.lingxinai.lingxinai_app.controller;

import com.lingxinai.lingxinai_app.constant.HttpStatusCode;
import com.lingxinai.lingxinai_app.entity.BugType;
import com.lingxinai.lingxinai_app.entity.ContactUs;
import com.lingxinai.lingxinai_app.entity.Feedback;
import com.lingxinai.lingxinai_app.entity.LingxinResponse;
import com.lingxinai.lingxinai_app.service.FeedbackService;
import com.lingxinai.lingxinai_app.utils.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.DataTruncation;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/feedback")
@Slf4j
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @PostMapping(value = "add_feedback")
    public LingxinResponse addFeedback(@RequestBody Map<String,Object> params){
        Map<String,Object> data = new HashMap<>();
        if (!params.containsKey("user_id")){
            return CommonUtils.buildFailedResponse(HttpStatusCode.ADD_FEEDBACK_USER_ID_EMPTY.getCode(),
                    HttpStatusCode.ADD_FEEDBACK_USER_ID_EMPTY.getMessage(), data);
        }
        if (!params.containsKey("bug_type")){
            return CommonUtils.buildFailedResponse(HttpStatusCode.ADD_FEEDBACK_BUG_TYPE_EMPTY.getCode(),
                    HttpStatusCode.ADD_FEEDBACK_BUG_TYPE_EMPTY.getMessage(), data);
        }
        if (!params.containsKey("bug_desc")){
            return CommonUtils.buildFailedResponse(HttpStatusCode.ADD_FEEDBACK_BUG_DESC_EMPTY.getCode(),
                    HttpStatusCode.ADD_FEEDBACK_BUG_DESC_EMPTY.getMessage(), data);
        }
        if (!params.containsKey("phone_number")){
            return CommonUtils.buildFailedResponse(HttpStatusCode.ADD_FEEDBACK_PHONE_NUMBER_EMPTY.getCode(),
                    HttpStatusCode.ADD_FEEDBACK_PHONE_NUMBER_EMPTY.getMessage(), data);
        }
        String userId = (String) params.get("user_id");
        String bugType = (String) params.get("bug_type");
        String bugDesc = (String) params.get("bug_desc");
        String phoneNumber = (String) params.get("phone_number");

        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTime = df.format(date);

        Feedback feedback = feedbackService.addFeedback(userId,bugType,bugDesc,phoneNumber,createTime);
        if (feedback != null){
            data.put("bug_id",feedback.getBugId());
            data.put("bug_type",feedback.getBugType());
            data.put("bug_desc",feedback.getBugDesc());
            data.put("phone_number",feedback.getPhoneNumber());
            return CommonUtils.buildSuccessResponse(data);
        }else {
            return CommonUtils.buildFailedResponse(HttpStatusCode.ADD_FEEDBACK_FAILED.getCode(),
                    HttpStatusCode.ADD_FEEDBACK_FAILED.getMessage(), data);
        }
    }

    @GetMapping(value = "/contact_us")
    public LingxinResponse contactUs(){
        List<ContactUs> contactUses = feedbackService.contactUs();
        Map<String,Object> data = new HashMap<>();
        ContactUs contact = null;
        if (contactUses.size() > 0){
            contact = contactUses.get(0);
            data.put("contactUs",contact);
            return CommonUtils.buildSuccessResponse(data);
        }else{
            return CommonUtils.buildSuccessResponse(data);
        }

    }

    @GetMapping(value = "/get_bug_types")
    public LingxinResponse getBugType(){
        List<BugType> bugTypes = feedbackService.getBugType();
        Map<String,Object> data = new HashMap<>();
        if (bugTypes.size() > 0){
            data.put("dataType", bugTypes);
            return CommonUtils.buildSuccessResponse(data);
        }else {
            return CommonUtils.buildSuccessResponse(data);
        }
    }
}
