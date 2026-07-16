package com.example.javaapi.coupon.domain.applicationservice.coupon.couponUsage;

import com.example.javaapi.coupon.domain.entity.CouponUsage;
import com.example.javaapi.coupon.domain.exception.ClientCouponNotFoundExcpetion;
import com.example.javaapi.coupon.domain.repository.CouponUsageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ListCouponUsage {

    private final CouponUsageRepository couponUsageRepository;

    public List<CouponUsage> listCouponUsage(String clientId) {

        if (Objects.isNull(clientId)) {
            return List.of();
        }

        return couponUsageRepository.findByClientId(clientId);
    }
}
