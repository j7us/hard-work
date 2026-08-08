package org.example.calculate;

import org.example.calculate.dto.Product;
import org.example.calculate.kafka.KafkaOutboxSender;
import org.example.calculate.repository.ProductRepository;
import org.example.calculate.repository.RatingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculateAndSendRating {
    private final KafkaOutboxSender kafkaOutboxSender;
    private final ProductRepository productRepository;
    private final RatingRepository ratingRepository;

    public CalculateAndSendRating(KafkaOutboxSender kafkaOutboxSender, ProductRepository productRepository, RatingRepository ratingRepository) {
        this.kafkaOutboxSender = kafkaOutboxSender;
        this.productRepository = productRepository;
        this.ratingRepository = ratingRepository;
    }

    public void updateAndSendRating(List<Product> productList) {
        List<Long> productIds = productList.stream().map(Product::getId).toList();
        int rating = productRepository.sumAllRatingForProductsIn(productIds);

        Long shopId = productList.stream().map(Product::getShopId).findFirst().orElseThrow();
        ratingRepository.saveRating(shopId, rating);

        int avgRating = rating / productIds.size();
        kafkaOutboxSender.saveAndSend(avgRating);
    }
}
