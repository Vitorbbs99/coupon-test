package com.example.javaapi.coupon.domain.applicationservice.coupon;

import com.example.javaapi.coupon.domain.entity.Coupon;
import com.example.javaapi.coupon.domain.exception.CouponNotFoundException;
import com.example.javaapi.coupon.domain.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ListCoupons {

    @Autowired
    private CouponRepository couponRepository;

    public Page<Coupon> getAllCoupons(String code, Boolean deleted, Pageable pageable) {
        if (code != null && deleted != null) {
            return couponRepository.findByCodeContainingIgnoreCaseAndDeleted(code, deleted, pageable);
        }
        // Filtrar apenas por Código
        if (code != null) {
            return couponRepository.findByCodeContainingIgnoreCase(code, pageable);
        }
        // Filtrar apenas por Status
        if (deleted != null) {
            return couponRepository.findByDeleted(deleted, pageable);
        }

        return couponRepository.findAll(pageable);
    }

    public Coupon getCouponById(String couponId) {
        return couponRepository
                .findByIdAndDeleted(couponId, false)
                .orElseThrow(() -> new CouponNotFoundException(couponId));
    }
}
