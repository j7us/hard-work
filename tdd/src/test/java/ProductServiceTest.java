import org.example.entity.Product;
import org.example.service.ProductService;
import org.example.repository.ProductRepository;
import org.example.service.ProductStatusCalculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    ProductRepository productRepository;

    @Mock
    ProductStatusCalculator productStatusCalculator;

    @InjectMocks
    ProductService productService;

    @Test
    void createProductObjectTest() {
        ProductService ps = new ProductService(productRepository, productStatusCalculator);
        assertThat(ps).isNotNull();
    }

    @Test
    void getProductNoSuchElementTest() {
        when(productRepository.findById(any())).thenReturn(Optional.empty());

        String status = productService.getActualStatus(UUID.randomUUID());
        assertThat(status).isEqualTo("NO_SUCH_ELEMENT");
    }

    @Test
    void getProductStatusFromCalculator() {
        when(productRepository.findById(any())).thenReturn(
                Optional.of(new Product(UUID.randomUUID(), "a", LocalDateTime.now(), true, 5, 0))
        );
        when(productStatusCalculator.calculateCurrentStatus(any())).thenReturn("AWAITING");

        String status = productService.getActualStatus(UUID.randomUUID());
        assertThat(status).isEqualTo("AWAITING");
    }
}
