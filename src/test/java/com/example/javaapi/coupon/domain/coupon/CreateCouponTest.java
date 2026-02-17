package com.example.javaapi.coupon.domain.coupon;

import com.example.javaapi.coupon.domain.applicationservice.coupon.CreateCoupon;
import com.example.javaapi.coupon.domain.entity.Coupon;
import com.example.javaapi.coupon.domain.repository.CouponRepository;
import com.example.javaapi.coupon.infrastructure.dto.SaveCouponDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class CreateCouponTest {

    @Mock
    private CouponRepository couponRepository;

    @InjectMocks
    private CreateCoupon createCoupon;

    @Test
    void testCreateCoupon() {
        Coupon couponFake = new Coupon();
        couponFake.setId("3dbbss4446644-44-4555vbb");
        couponFake.setCode("ABC@@@123");

        when(couponRepository.save(any(Coupon.class))).thenReturn(couponFake);
        Coupon result = createCoupon.createCoupon(new SaveCouponDTO("ABC@@@123", "teste", 0.5, LocalDateTime.now().plusDays(10), true));

        System.out.println("Retorno do service (sem regras de negócio): " + result);
        assertNotNull(result.getId());
        assertEquals("3dbbss4446644-44-4555vbb", result.getId());
    }

    @Test
    void cleanSpecialsCharactersCode() {
        SaveCouponDTO dtoSpecialsChars = new SaveCouponDTO("ABC-222@", "teste", 0.5, LocalDateTime.now().plusDays(1), true);

        when(couponRepository.save(any(Coupon.class))).thenAnswer(i -> i.getArgument(0));

        Coupon result = createCoupon.createCoupon(dtoSpecialsChars);
        System.out.println("Retorno deve ser (ABC222): " + result.getCode());
        assertNotNull(result.getCode());
        assertEquals("ABC222", result.getCode());
    }

    @Test
    void testDateInThePast() {
        SaveCouponDTO dtoDateInThePast = new SaveCouponDTO("ABC-222@", "teste", 0.5, LocalDateTime.now().minusDays(1), true);

        assertThrows(IllegalArgumentException.class, () -> {
            createCoupon.createCoupon(dtoDateInThePast);
        });

        verify(couponRepository, never()).save(any(Coupon.class));

    }

    @Test
    void testMinimumDiscount() {
        SaveCouponDTO dtoDiscountInvalid = new SaveCouponDTO("ABC-222@", "teste", 0.4, LocalDateTime.now().plusDays(1), true);

        assertThrows(IllegalArgumentException.class, () -> {
            createCoupon.createCoupon(dtoDiscountInvalid);
        });

        verify(couponRepository, never()).save(any(Coupon.class));

    }

}
