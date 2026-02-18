package com.example.javaapi.coupon.domain.applicationservice.coupon;

import com.example.javaapi.coupon.domain.entity.Coupon;
import com.example.javaapi.coupon.domain.exception.DuplicateCouponException;
import com.example.javaapi.coupon.domain.repository.CouponRepository;
import com.example.javaapi.coupon.infrastructure.dto.SaveCouponDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CreateCoupon {
    private final CouponRepository couponRepository;

    @Transactional
    public Coupon createCoupon(SaveCouponDTO saveCouponDTO) {

        CleanCode validatedCode = new CleanCode(saveCouponDTO.getCode());

        if (existsCouponWithCode(validatedCode.code(), null)) {
            throw new DuplicateCouponException(validatedCode.code());
        }

        Coupon coupon = Coupon
                .builder()
                .code(validatedCode.code())
                .description(saveCouponDTO.getDescription())
                .discountValue(saveCouponDTO.getDiscountValue())
                .expirationDate(saveCouponDTO.getExpirationDate())
                .published(saveCouponDTO.getPublished())
                .deleted(false)
                .build();

        return couponRepository.save(coupon);
    }

   private boolean existsCouponWithCode(String code, String idToExclude) {
        return couponRepository
                .findByCode(code)
                .filter(c -> !Objects.equals(c.getId(), idToExclude))
                .isPresent();
    }
}
