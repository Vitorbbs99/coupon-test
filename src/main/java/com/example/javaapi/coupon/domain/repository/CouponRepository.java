package com.example.javaapi.coupon.domain.repository;

import com.example.javaapi.coupon.domain.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, String> {
}
