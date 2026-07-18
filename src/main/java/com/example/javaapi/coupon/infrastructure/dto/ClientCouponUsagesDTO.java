package com.example.javaapi.coupon.infrastructure.dto;

import com.example.javaapi.coupon.domain.entity.CouponUsage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientCouponUsagesDTO {
    private String id;
    private LocalDateTime createdAt;
    private CouponDTO couponDTO;

    public static ClientCouponUsagesDTO create(CouponUsage couponUsage) {
        return new ClientCouponUsagesDTO(
                couponUsage.getId(),
                couponUsage.getCreatedAt(),
                Optional.ofNullable(couponUsage.getCoupon()).map(CouponDTO::create).orElse(null)
        );
    }
}
