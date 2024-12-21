package com.example.intranet.controller.healthCheck;

import com.example.intranet.apiPayload.BaseResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthChecker {

    @GetMapping("/healthy")
    public BaseResponse<String> health() {
        return BaseResponse.onSuccess("i'm healthy!");
    }
}
