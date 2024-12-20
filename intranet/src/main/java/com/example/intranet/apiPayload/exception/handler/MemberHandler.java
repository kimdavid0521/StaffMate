package com.example.intranet.apiPayload.exception.handler;

import com.example.intranet.apiPayload.code.BaseErrorCode;
import com.example.intranet.apiPayload.exception.GeneralException;

public class MemberHandler extends GeneralException {
    public MemberHandler(BaseErrorCode code) {
        super(code);
    }
}
