package com.example.javaapi.coupon.infrastructure.controller;

import com.example.javaapi.coupon.domain.applicationservice.Coupon.CreateCoupon;
import com.example.javaapi.coupon.domain.entity.Coupon;
import com.example.javaapi.coupon.infrastructure.dto.CouponDTO;
import com.example.javaapi.coupon.infrastructure.dto.SaveCouponDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

import static com.example.javaapi.coupon.infrastructure.controller.RestConstants.PATH_COUPON;

@RestController
@RequestMapping(PATH_COUPON)
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class CouponRestResource {
    private final CreateCoupon createCoupon;

    @PostMapping
    public ResponseEntity<CouponDTO> createCoupon(@RequestBody @Valid SaveCouponDTO saveCouponDTO) {
        Coupon coupon = createCoupon.createCoupon(saveCouponDTO);

        return ResponseEntity
                .created(URI.create(PATH_COUPON + "/" + coupon.getId()))
                .body(CouponDTO.create(coupon));
    }
}
