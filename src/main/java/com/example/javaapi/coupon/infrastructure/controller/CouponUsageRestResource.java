package com.example.javaapi.coupon.infrastructure.controller;

import com.example.javaapi.coupon.domain.applicationservice.coupon.couponUsage.CreateCouponUsage;
import com.example.javaapi.coupon.infrastructure.dto.SaveCouponUsageDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.javaapi.coupon.infrastructure.controller.RestConstants.PATH_COUPON_USAGE;

@RestController
@RequestMapping(PATH_COUPON_USAGE)
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class CouponUsageRestResource {
    private final CreateCouponUsage createCouponUsage;

    @PostMapping
    public ResponseEntity<Void> createCouponUsage(@RequestBody @Valid SaveCouponUsageDTO saveCouponUsageDTO) {
        createCouponUsage.createCouponUsage(saveCouponUsageDTO);
        return ResponseEntity.noContent().build();
    }
}
