package com.example.javaapi.coupon.domain.exception;

import com.example.javaapi.coupon.infrastructure.exception.RequestException;

public class DuplicateClientCouponUsage extends RequestException {
    public DuplicateClientCouponUsage(String clientId) {
        super("ClientCouponUsage", "The customer has already used the coupon: " + clientId);
    }
}
