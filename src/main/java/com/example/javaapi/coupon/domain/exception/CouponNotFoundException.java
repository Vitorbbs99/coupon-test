package com.example.javaapi.coupon.domain.exception;

import com.example.javaapi.coupon.infrastructure.exception.RequestException;

public class CouponNotFoundException extends RequestException {
    public CouponNotFoundException(String couponId) {
        super("CouponNotFound", "Coupon not found: " + couponId);
    }
}
