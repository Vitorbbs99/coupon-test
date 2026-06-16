package com.example.javaapi.coupon.domain.applicationservice.coupon;

import com.example.javaapi.coupon.domain.entity.Coupon;
import com.example.javaapi.coupon.domain.exception.DuplicateCouponException;
import com.example.javaapi.coupon.domain.repository.CouponRepository;
import com.example.javaapi.coupon.infrastructure.dto.SaveCouponDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateCoupon {
    private final CouponRepository couponRepository;
    private final LoadCoupon loadCoupon;
    private final CreateCoupon createCoupon;

    @Transactional
    public Coupon updateCoupon(SaveCouponDTO saveCouponDTO, String couponId) {
        Coupon coupon = loadCoupon.LoadCoupon(couponId);

        CleanCode validatedCode = new CleanCode(saveCouponDTO.getCode());

        if (createCoupon.existsCouponWithCode(validatedCode.code(), couponId)) {
            throw new DuplicateCouponException(validatedCode.code());
        }

        coupon.setCode(validatedCode.code());
        coupon.setDescription(saveCouponDTO.getDescription());
        coupon.setDiscountValue(saveCouponDTO.getDiscountValue());
        coupon.setExpirationDate(saveCouponDTO.getExpirationDate());
        coupon.setPublished(saveCouponDTO.getPublished());

        return coupon;
    }
}
