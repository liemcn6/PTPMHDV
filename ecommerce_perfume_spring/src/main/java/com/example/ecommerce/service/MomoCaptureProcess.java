package com.example.ecommerce.service;


import com.example.ecommerce.dto.momo.CaptureRequest;
import com.example.ecommerce.dto.momo.CaptureResponse;

public interface MomoCaptureProcess {
    CaptureResponse execute(CaptureRequest paymentRequest);
}
