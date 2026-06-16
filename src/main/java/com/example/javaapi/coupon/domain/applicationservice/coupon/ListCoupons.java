package com.example.javaapi.coupon.domain.applicationservice.coupon;

import com.example.javaapi.coupon.domain.entity.Coupon;
import com.example.javaapi.coupon.domain.exception.CouponNotFoundException;
import com.example.javaapi.coupon.domain.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListCoupons {

    @Autowired
    private CouponRepository couponRepository;

    public List<Coupon> getAllCoupons() {
        return couponRepository.findAll();
    }

    public Coupon getCouponById(String couponId) {
        return couponRepository
                .findByIdAndDeleted(couponId, false)
                .orElseThrow(() -> new CouponNotFoundException(couponId));
    }
}
