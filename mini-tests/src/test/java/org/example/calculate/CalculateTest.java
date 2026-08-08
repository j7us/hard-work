package org.example.calculate;

import org.example.calculate.dto.Product;
import org.example.calculate.kafka.KafkaOutboxSender;
import org.example.calculate.repository.ProductRepository;
import org.example.calculate.repository.RatingRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculateTest {

    @Mock
    KafkaOutboxSender kafkaOutboxSender;
    @Mock
    ProductRepository productRepository;
    @Mock
    RatingRepository ratingRepository;

    @InjectMocks
    CalculateAndSendRating calculateAndSendRating;

    @Test
    @DisplayName("Успешное сохранение в новый репозиторий")
    void addNewTableSaveRatingTest() {
        //WHEN
        calculateAndSendRating.updateAndSendRating(List.of(new Product(1L,1L)));

        //THEN
        Mockito.verify(ratingRepository).saveRating(any(),anyInt());
    }

    @Test
    @DisplayName("Проверка, что в новую таблицу сохраняеься полный рейтинг")
    void saveFullRatingInNewTableTest() {
        //GIVEN
        when(productRepository.sumAllRatingForProductsIn(any())).thenReturn(20);

        //WHEN
        calculateAndSendRating.updateAndSendRating(List.of(new Product(1L,1L), new Product(2L,1L)));

        //THEN
        Mockito.verify(ratingRepository).saveRating(1L, 20);
    }

    @Test
    @DisplayName("Проверка, что в outbox сохраняется средний рейтинг")
    void sendAvgRatingToKafkaOutboxTest() {
        //GIVEN
        when(productRepository.sumAllRatingForProductsIn(any())).thenReturn(20);

        //WHEN
        calculateAndSendRating.updateAndSendRating(List.of(new Product(1L,1L), new Product(2L,1L)));

        //THEN
        Mockito.verify(kafkaOutboxSender).saveAndSend(10);
    }
}
