package com.example.javaapi.coupon.domain.applicationservice.coupon.couponUsage;

import com.example.javaapi.coupon.domain.applicationservice.coupon.LoadCoupon;
import com.example.javaapi.coupon.domain.entity.Coupon;
import com.example.javaapi.coupon.domain.entity.CouponUsage;
import com.example.javaapi.coupon.domain.exception.DuplicateClientCouponUsage;
import com.example.javaapi.coupon.domain.repository.CouponUsageRepository;
import com.example.javaapi.coupon.infrastructure.dto.SaveCouponUsageDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateCouponUsage {
    private final CouponUsageRepository couponUsageRepository;
    private final LoadCoupon loadCoupon;

    public void createCouponUsage(SaveCouponUsageDTO saveCouponUsageDTO) {
        if (existsClientWithCoupon(saveCouponUsageDTO.getClientId(), saveCouponUsageDTO.getCouponId())) {
            throw new DuplicateClientCouponUsage(saveCouponUsageDTO.getClientId());
        }

        Coupon coupon = getCoupounIfExists(saveCouponUsageDTO.getCouponId());

        CouponUsage couponUsage = CouponUsage
                .builder()
                .clientId(saveCouponUsageDTO.getClientId())
                .coupon(coupon)
                .build();

        couponUsageRepository.save(couponUsage);
    }

    public boolean existsClientWithCoupon(String clientId, String couponId) {
        return couponUsageRepository
                .findByClientIdAndCouponId(clientId, couponId)
                .isPresent();
    }

    public Coupon getCoupounIfExists (String couponId) {
        Coupon coupon = null;
        if(!Objects.isNull(couponId)) {
            coupon = loadCoupon.LoadCoupon(couponId);
        }
        return coupon;
    }
}
