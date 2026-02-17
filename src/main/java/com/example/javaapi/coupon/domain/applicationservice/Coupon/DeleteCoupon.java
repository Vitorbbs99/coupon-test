package com.example.javaapi.coupon.domain.applicationservice.Coupon;

import com.example.javaapi.coupon.domain.entity.Coupon;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteCoupon {

    private final LoadCoupon loadCoupon;

    @Transactional
    public void deleteCoupon(String couponId) {

        Coupon coupon = loadCoupon.LoadCoupon(couponId);
        coupon.setDeleted(true);

    }

}
