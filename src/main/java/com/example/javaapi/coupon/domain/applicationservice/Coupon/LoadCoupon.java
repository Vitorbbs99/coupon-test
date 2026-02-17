package com.example.javaapi.coupon.domain.applicationservice.Coupon;

import com.example.javaapi.coupon.domain.entity.Coupon;
import com.example.javaapi.coupon.domain.exception.CouponNotFoundException;
import com.example.javaapi.coupon.domain.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoadCoupon {

    private final CouponRepository couponRepository;

    public Coupon LoadCoupon (String couponId) {
        return couponRepository
                .findByIdAndDeleted(couponId, false)
                .orElseThrow(() -> new CouponNotFoundException("Coupon not found"));
    }
}
