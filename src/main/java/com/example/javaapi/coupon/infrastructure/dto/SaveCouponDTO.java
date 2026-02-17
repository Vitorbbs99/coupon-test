package com.example.javaapi.coupon.infrastructure.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SaveCouponDTO {

    @NotNull(message = "Code cannot be empty")
    @Size(min = 6, max = 6, message = "Invalid Code")
    private final String code;

    @NotNull(message = "Description cannot be empty")
    @Size(min = 1, max = 150, message = "Invalid description")
    private final String description;

    @PositiveOrZero(message = "Discount must be greater than or equal to 0")
    private final double discountValue;

    @NotNull(message = "ExpirationDate cannot be empty")
    private final LocalDateTime expirationDate;

    private final Boolean published;
}
