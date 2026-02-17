package com.example.javaapi.coupon.domain.exception;

public class DuplicateCouponException extends RuntimeException {
  public DuplicateCouponException(String message) {
    super(message);
  }
}
