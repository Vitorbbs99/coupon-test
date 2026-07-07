package com.example.javaapi.coupon.infrastructure.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class SaveCouponUsageDTO {

    @NotNull(message = "Client cannot be empty")
    private final String clientId;

    @NotNull(message = "Coupon cannot be empty")
    private final String couponId;
}
