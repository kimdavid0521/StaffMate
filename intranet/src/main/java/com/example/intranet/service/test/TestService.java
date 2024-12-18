package com.example.intranet.service.test;

import com.example.intranet.apiPayload.code.status.ErrorStatus;
import com.example.intranet.apiPayload.exception.handler.TestHandler;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    // 에러응답 통일 테스트용 api
    public void failedTest() {
        if(1==1) {
            throw new TestHandler(ErrorStatus._BAD_REQUEST);
        }
    }
}
