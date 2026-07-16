package com.example.javaapi.coupon.domain.repository;

import com.example.javaapi.coupon.domain.entity.Coupon;
import com.example.javaapi.coupon.domain.entity.CouponUsage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CouponUsageRepository extends JpaRepository<CouponUsage, String> {

    Optional<CouponUsage> findByClientIdAndCouponId(String clientId, String coupon_id);

    List<CouponUsage> findByClientId(String clientId);

}
