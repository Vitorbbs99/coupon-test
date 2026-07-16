package com.example.javaapi.coupon.domain.exception;

import com.example.javaapi.coupon.infrastructure.exception.RequestException;

public class ClientCouponNotFoundExcpetion extends RequestException {
    public ClientCouponNotFoundExcpetion(String clientId) {
        super("ClientNotFoundCouponUsage", "The customer not found: " + clientId);
    }
}
