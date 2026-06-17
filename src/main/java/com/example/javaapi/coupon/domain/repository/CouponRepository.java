package com.example.javaapi.coupon.domain.repository;

import com.example.javaapi.coupon.domain.entity.Coupon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, String> {

    Optional<Coupon> findByCode(String code);
    Optional<Coupon> findByIdAndDeleted(String id, boolean deleted);

    // Filtro de cupons
    Page<Coupon> findByCodeContainingIgnoreCaseAndDeleted(String code, Boolean deleted, Pageable pageable);
    Page<Coupon> findByCodeContainingIgnoreCase(String code, Pageable pageable);
    Page<Coupon> findByDeleted(Boolean deleted, Pageable pageable);
}
