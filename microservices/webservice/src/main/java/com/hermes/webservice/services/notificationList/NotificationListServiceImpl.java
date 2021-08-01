package com.hermes.webservice.services.notificationList;

import com.hermes.webservice.exceptions.NotificationListNotFoundException;
import com.hermes.webservice.models.NotificationList;
import com.hermes.webservice.repository.NotificationListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NotificationListServiceImpl implements NotificationListService
{
    @Autowired
    public NotificationListRepository notificationListRepository;

    @Override
    public String createNotificationList(NotificationList notificationList)
    {
        if(notificationList.getId() == null && notificationList.getId().equals(""))
        {
            notificationList.setId(UUID.randomUUID().toString());
            return notificationListRepository.insert(notificationList).getId();
        }

        var notificationListFound = notificationListRepository.findById(notificationList.getId());

        if(notificationListFound.isPresent()) {
            notificationListRepository.save(notificationList);
            return notificationList.getId();
        }
        else
        {
            return notificationListRepository.insert(notificationList).getId();
        }
    }

    @Override
    public NotificationList findNotificationList(String id)
    {
        return notificationListRepository.findById(id).stream().findFirst()
                .orElseThrow(NotificationListNotFoundException::new);
    }

    @Override
    public List<NotificationList> getAllNotificationlist()
    {
        return notificationListRepository.findAll();
    }

    @Override
    public void deleteNotificationList(String id)
    {
        var notificationList = notificationListRepository.findById(id)
                .orElseThrow(NotificationListNotFoundException::new);
    }
}
