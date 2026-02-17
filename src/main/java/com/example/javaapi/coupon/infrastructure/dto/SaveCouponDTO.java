package com.example.javaapi.coupon.infrastructure.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SaveCouponDTO {

    @NotNull(message = "Code cannot be empty")
    @Size(min = 1, message = "Invalid Code")
    private final String code;

    @NotNull(message = "Description cannot be empty")
    @Size(min = 1, max = 150, message = "Invalid description")
    private final String description;

    @DecimalMin(value = "0.5", message = "Minimum discount is 0.5")
    private final double discountValue;

    @NotNull(message = "ExpirationDate cannot be empty")
    @FutureOrPresent(message = "Coupons cannot be accepted if the expiration date has passed")
    private final LocalDateTime expirationDate;

    private final Boolean published;
}
