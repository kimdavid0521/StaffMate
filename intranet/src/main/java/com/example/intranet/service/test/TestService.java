package com.example.intranet.service.test;

import com.example.intranet.apiPayload.code.status.ErrorStatus;
import com.example.intranet.apiPayload.exception.handler.TestHandler;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    public void failedTest() {
        if(1==1) {
            throw new TestHandler(ErrorStatus._BAD_REQUEST);
        }
    }
}
