package com.example.javaapi.coupon.infrastructure.dto;

import com.example.javaapi.coupon.domain.entity.CouponUsage;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ClientCouponUsagesDTO {
    private final String id;
    private final LocalDateTime createdAt;

    public static ClientCouponUsagesDTO create(CouponUsage couponUsage) {
        return new ClientCouponUsagesDTO(
                couponUsage.getId(),
                couponUsage.getCreatedAt()
        );
    }
}
