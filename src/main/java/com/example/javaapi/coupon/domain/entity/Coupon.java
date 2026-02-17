package com.example.javaapi.coupon.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Coupon {

    @Id
    @GeneratedValue(strategy = UUID)
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Column(name = "code", nullable = false, length = 6)
    private String code;

    @Column(name = "description", nullable = false, length = 150)
    private String description;

    @Column(name = "discountValue", nullable = false)
    private double discountValue;

    @Column(name = "expiration_date", nullable = false)
    private LocalDateTime expirationDate;

    @Column(name = "is_published", nullable = false)
    private Boolean published;

    @Column(name = "deleted", nullable = false)
    private Boolean deleted;
}
