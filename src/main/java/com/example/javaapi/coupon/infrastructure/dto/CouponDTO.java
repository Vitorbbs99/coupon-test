package com.example.javaapi.coupon.infrastructure.dto;

import com.example.javaapi.coupon.domain.entity.Coupon;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CouponDTO {
    private final String id;
    private final String code;
    private final String description;
    private final double discountValue;
    private final LocalDateTime expirationDate;
    private final Boolean published;

    public static CouponDTO create(Coupon coupon) {
        return new CouponDTO(
                coupon.getId(),
                coupon.getCode(),
                coupon.getDescription(),
                coupon.getDiscountValue(),
                coupon.getExpirationDate(),
                coupon.getPublished()
        );
    }
}
