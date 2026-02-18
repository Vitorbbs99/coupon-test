package com.example.javaapi.coupon.domain.exception;

import com.example.javaapi.coupon.infrastructure.exception.RequestException;

public class DuplicateCouponException  extends RequestException {
  public DuplicateCouponException(String code) {
      super("CouponDuplicated", "A Coupon with the code already exists: " + code);
  }
}
