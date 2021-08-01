package com.hermes.webservice.repository;

import com.hermes.webservice.models.Recipient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipientRepository extends MongoRepository<Recipient, String> {
}
