package com.example.javaapi.coupon.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.UUID;

@Entity
@Data
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor()
@Table(name = "coupon")
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

    @Builder
    public Coupon(String code, String description, Double discountValue, LocalDateTime expirationDate, Boolean published, Boolean deleted) {
        validate(discountValue, expirationDate);
        this.code = code;
        this.description = description;
        this.discountValue = discountValue;
        this.expirationDate = expirationDate;
        this.published = published;
        this.deleted = deleted;
    }

    private void validate(double discount, LocalDateTime expiration) {
        if (expiration.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Data inválida");
        }
        if (discount < 0.5) {
            throw new IllegalArgumentException("Desconto insuficiente");
        }
    }
}
