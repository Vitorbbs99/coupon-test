package com.example.javaapi.coupon.domain.applicationservice.Coupon;

import com.example.javaapi.coupon.domain.entity.Coupon;
import com.example.javaapi.coupon.domain.exception.DuplicateCouponException;
import com.example.javaapi.coupon.domain.repository.CouponRepository;
import com.example.javaapi.coupon.infrastructure.dto.SaveCouponDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CreateCoupon {
    private final CouponRepository couponRepository;

    @Transactional
    public Coupon createCoupon(SaveCouponDTO saveCouponDTO) {
        if (existsCouponWithCode(saveCouponDTO.getCode(), null)) {
            throw new DuplicateCouponException("Esse cupom já existe!");
        }

        Coupon coupon = Coupon
                .builder()
                .code(saveCouponDTO.getCode())
                .description(saveCouponDTO.getDescription())
                .discountValue(saveCouponDTO.getDiscountValue())
                .expirationDate(saveCouponDTO.getExpirationDate())
                .published(saveCouponDTO.getPublished())
                .deleted(false)
                .build();

        couponRepository.save(coupon);
        return coupon;
    }

   private boolean existsCouponWithCode(String code, String idToExclude) {
        return couponRepository
                .findByCode(code)
                .filter(c -> !Objects.equals(c.getId(), idToExclude))
                .isPresent();
    }
}
