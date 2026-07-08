import org.example.entity.Product;
import org.example.service.ProductStatusCalculator;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductStatusCalculatorTest {

    ProductStatusCalculator productStatusCalculator = new ProductStatusCalculator();

    @Test
    void calculateStatusDelayedTest() {
        String resultStatus = productStatusCalculator.calculateCurrentStatus(
                new Product(UUID.randomUUID(), "a", LocalDateTime.now().minusDays(10), false, 5, 0)
        );

        assertThat(resultStatus).isEqualTo("DELAYED");
    }

    @Test
    void calculateStatusAwaitingTest() {
        String resultStatus = productStatusCalculator.calculateCurrentStatus(
                new Product(UUID.randomUUID(), "a", LocalDateTime.now().minusDays(5), false, 5, 0)
        );

        assertThat(resultStatus).isEqualTo("AWAITING");
    }

    @Test
    void calculateStatusIssuedTest() {
        String resultStatus = productStatusCalculator.calculateCurrentStatus(
                new Product(UUID.randomUUID(), "a", LocalDateTime.now().minusDays(5), true, 5, 0)
        );

        assertThat(resultStatus).isEqualTo("ISSUED");
    }

    @Test
    void calculateStatushalsOrderTest() {
        String resultStatus = productStatusCalculator.calculateCurrentStatus(
                new Product(UUID.randomUUID(), "a", LocalDateTime.now().minusDays(5), false, 5, 3)
        );

        assertThat(resultStatus).isEqualTo("HALF_ORDERED");
    }
}
