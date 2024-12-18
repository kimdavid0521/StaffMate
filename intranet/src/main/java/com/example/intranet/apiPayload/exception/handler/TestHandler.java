package com.example.intranet.apiPayload.exception.handler;

import com.example.intranet.apiPayload.code.BaseErrorCode;
import com.example.intranet.apiPayload.exception.GeneralException;

public class TestHandler extends GeneralException {
    public TestHandler(BaseErrorCode code) {
        super(code);
    }
}
