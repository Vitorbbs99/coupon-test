package com.example.javaapi.coupon.infrastructure.controller;

import com.example.javaapi.coupon.domain.applicationservice.coupon.CreateCoupon;
import com.example.javaapi.coupon.domain.applicationservice.coupon.DeleteCoupon;
import com.example.javaapi.coupon.domain.applicationservice.coupon.ListCoupons;
import com.example.javaapi.coupon.domain.applicationservice.coupon.UpdateCoupon;
import com.example.javaapi.coupon.domain.entity.Coupon;
import com.example.javaapi.coupon.infrastructure.dto.CouponDTO;
import com.example.javaapi.coupon.infrastructure.dto.SaveCouponDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static com.example.javaapi.coupon.infrastructure.controller.RestConstants.PATH_COUPON;

@RestController
@RequestMapping(PATH_COUPON)
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class CouponRestResource {
    private final CreateCoupon createCoupon;
    private final DeleteCoupon deleteCoupon;
    private final ListCoupons listCoupons;
    private final UpdateCoupon updateCoupon;

    @PostMapping
    public ResponseEntity<CouponDTO> createCoupon(@RequestBody @Valid SaveCouponDTO saveCouponDTO) {
        Coupon coupon = createCoupon.createCoupon(saveCouponDTO);

        return ResponseEntity
                .created(URI.create(PATH_COUPON + "/" + coupon.getId()))
                .body(CouponDTO.create(coupon));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CouponDTO> updateCoupon(
            @RequestBody @Valid SaveCouponDTO saveCouponDTO,
            @PathVariable("id") String couponId
    ) {
        Coupon coupon = updateCoupon.updateCoupon(saveCouponDTO, couponId);
        return ResponseEntity.ok(CouponDTO.create(coupon));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoupon(@PathVariable("id") String couponId) {
        deleteCoupon.deleteCoupon(couponId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<Coupon>> getAll(
            @RequestParam(value = "code", required = false) String code,
            @RequestParam(value = "deleted", required = false) Boolean deleted,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());

        Page<Coupon> coupons = listCoupons.getAllCoupons(code, deleted, pageable);
        return ResponseEntity.ok(coupons);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CouponDTO> getCouponById(@PathVariable("id") String couponId) {
        Coupon coupon = listCoupons.getCouponById(couponId);
        return ResponseEntity.ok(CouponDTO.create(coupon));
    }
}
