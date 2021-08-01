package com.hermes.webservice.services.notification;

import com.hermes.webservice.exceptions.NotificationNotFoundException;
import com.hermes.webservice.models.Notification;
import com.hermes.webservice.models.Recipient;
import com.hermes.webservice.repository.NotificationRepository;
import com.hermes.webservice.repository.RecipientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository repository;

    @Autowired
    private RecipientRepository recipientRepositoryRepository;

    @Override
    public String createNotification(Notification notification) {
        if(notification.getId() == null && notification.getId().equals(""))
        {
            notification.setId(UUID.randomUUID().toString());
        }

        var insertedNotification = repository.insert(notification);
        return insertedNotification.getId();
    }

    @Override
    public Notification findNotification(String id) {
        var notification = repository.findById(id).stream().findFirst().orElseThrow(NotificationNotFoundException::new);

        var recipients = recipientRepositoryRepository.findAllById(notification.getRecipientsIds());

        var recipientsList = new ArrayList<Recipient>();

        recipients.forEach(recipientsList::add);

        notification.setRecipients(recipientsList);

        return notification;
    }

    @Override
    public List<Notification> getAllNotifications() {
        try {
            return repository.findAll();
        } catch (Exception ex)
        {
            System.out.println(ex);
            throw ex;
        }
    }

    @Override
    public void deleteNotification(String id) {
        var notification = findNotification(id);
        repository.delete(notification);
    }
}
