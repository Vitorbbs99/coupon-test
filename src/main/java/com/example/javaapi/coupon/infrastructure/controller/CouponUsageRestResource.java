package com.example.javaapi.coupon.infrastructure.controller;

import com.example.javaapi.coupon.domain.applicationservice.coupon.couponUsage.CreateCouponUsage;
import com.example.javaapi.coupon.domain.applicationservice.coupon.couponUsage.ListCouponUsage;
import com.example.javaapi.coupon.domain.entity.CouponUsage;
import com.example.javaapi.coupon.infrastructure.dto.ClientCouponUsagesDTO;
import com.example.javaapi.coupon.infrastructure.dto.SaveCouponUsageDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.javaapi.coupon.infrastructure.controller.RestConstants.PATH_COUPON_USAGE;

@RestController
@RequestMapping(PATH_COUPON_USAGE)
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class CouponUsageRestResource {
    private final CreateCouponUsage createCouponUsage;
    private final ListCouponUsage listCouponUsage;

    @PostMapping
    public ResponseEntity<Void> createCouponUsage(@RequestBody @Valid SaveCouponUsageDTO saveCouponUsageDTO) {
        createCouponUsage.createCouponUsage(saveCouponUsageDTO);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ClientCouponUsagesDTO>> getCouponByClient(
            @RequestParam(value = "client", required = false) String clientId
    ) {
        List<CouponUsage> couponUsages = listCouponUsage.listCouponUsage(clientId);
        return  ResponseEntity.ok(
                couponUsages.stream().map(ClientCouponUsagesDTO::create).toList()
        );

    }

}
