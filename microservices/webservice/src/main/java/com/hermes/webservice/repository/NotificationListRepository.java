package com.hermes.webservice.repository;

import com.hermes.webservice.models.NotificationList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationListRepository extends MongoRepository<NotificationList, String> {
}
