package org.example.calculate.repository;

import java.util.List;

public interface ProductRepository {

    int sumAllRatingForProductsIn(List<Long> productsId);
}
