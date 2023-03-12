package com.mrv.repository;

import com.mrv.model.ASYXProduct;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.util.List;

public interface ASYXProductRepository extends MongoRepository<ASYXProduct, String> {
    @Query(value="{$and: [{'price': {$gte: ?0}}, {'price': {$lte: ?1}}]}")
    List<ASYXProduct> findAllInRange(int initial_value, int final_value);

    public long count();
}
