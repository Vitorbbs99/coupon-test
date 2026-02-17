import com.example.javaapi.coupon.infrastructure.dto.SaveCouponDTO;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.assertFalse;

class SaveCouponDTOTest {

    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    void testDateInThePast() {
        SaveCouponDTO dto = new SaveCouponDTO("ABC-222@", "teste", 0.5, LocalDateTime.now().minusDays(1), true);
        assertFalse(validator.validate(dto).isEmpty());
    }

    @Test
    void testMinimumDiscount() {
        SaveCouponDTO dto = new SaveCouponDTO("ABC-222@", "teste", 0.4, LocalDateTime.now().plusDays(1), true);
        assertFalse(validator.validate(dto).isEmpty());
    }
}