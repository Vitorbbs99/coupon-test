package com.example.javaapi.coupon.infrastructure.controller;

import com.example.javaapi.coupon.domain.applicationservice.coupon.CreateCoupon;
import com.example.javaapi.coupon.domain.applicationservice.coupon.DeleteCoupon;
import com.example.javaapi.coupon.domain.entity.Coupon;
import com.example.javaapi.coupon.infrastructure.dto.CouponDTO;
import com.example.javaapi.coupon.infrastructure.dto.SaveCouponDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import static com.example.javaapi.coupon.infrastructure.controller.RestConstants.PATH_COUPON;

@RestController
@RequestMapping(PATH_COUPON)
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class CouponRestResource {
    private final CreateCoupon createCoupon;
    private final DeleteCoupon deleteCoupon;

    @PostMapping
    public ResponseEntity<CouponDTO> createCoupon(@RequestBody @Valid SaveCouponDTO saveCouponDTO) {
        Coupon coupon = createCoupon.createCoupon(saveCouponDTO);

        return ResponseEntity
                .created(URI.create(PATH_COUPON + "/" + coupon.getId()))
                .body(CouponDTO.create(coupon));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoupon(@PathVariable("id") String couponId) {
        deleteCoupon.deleteCoupon(couponId);
        return ResponseEntity.noContent().build();
    }
}
