package com.example.intranet.controller.test;

import com.example.intranet.apiPayload.BaseResponse;
import com.example.intranet.service.test.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping("/test")
    public BaseResponse<String> test() {
        return BaseResponse.onSuccess("응답 성공");
    }

    // 에러응답 통일 테스트용 api
    @GetMapping("/test/failed")
    public BaseResponse<String> failedTest() {
        testService.failedTest();
        return BaseResponse.onSuccess("성공");
    }
}
