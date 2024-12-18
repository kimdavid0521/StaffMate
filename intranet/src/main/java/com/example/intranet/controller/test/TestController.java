package com.example.intranet.controller.test;

import com.example.intranet.apiPayload.BaseResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public BaseResponse<String> test() {
        return BaseResponse.onSuccess("응답 성공");
    }
}
