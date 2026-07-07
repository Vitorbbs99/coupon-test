package com.example.javaapi.coupon.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;
import static jakarta.persistence.GenerationType.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "coupon_usage")
public class CouponUsage {

    @Id
    @GeneratedValue(strategy = UUID)
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Column(name = "clientId", nullable = false, length = 36)
    private String clientId;

    @CreationTimestamp
    @Column(name = "createdAt", updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "coupon_id")
    private Coupon coupon;
}
