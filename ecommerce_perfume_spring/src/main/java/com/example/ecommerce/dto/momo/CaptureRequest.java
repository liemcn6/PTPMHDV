package com.example.ecommerce.dto.momo;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@Data
public class CaptureRequest {

    @NotBlank
    private String orderId;
    @NotBlank
    private String requestId;
    @NotBlank
    private String orderInfo;
    private String returnUrl;
    private String notifyUrl;
    private String extraData;
    @NotNull
    private Long amount;
}
