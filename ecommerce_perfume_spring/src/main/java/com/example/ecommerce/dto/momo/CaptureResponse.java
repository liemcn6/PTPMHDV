package com.example.ecommerce.dto.momo;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CaptureResponse {
    private String orderId;
    private String requestId;
    private String message;
    private String payUrl;
}
