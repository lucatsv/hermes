package com.hermes.webservice.services.recipient;

import com.hermes.webservice.exceptions.NotificationNotFoundException;
import com.hermes.webservice.models.Recipient;
import com.hermes.webservice.repository.RecipientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RecipientServiceImpl implements RecipientService {

    @Autowired
    private RecipientRepository recipientRepository;

    @Override
    public String createRecipient(Recipient recipient) {
        if(recipient.getId() == null && recipient.getId().equals(""))
        {
            recipient.setId(UUID.randomUUID().toString());
        }
        return recipientRepository.insert(recipient).getId();
    }

    @Override
    public Recipient findRecipient(String id) {
        return recipientRepository.findById(id).stream().findFirst().orElseThrow(NotificationNotFoundException::new);
    }

    @Override
    public List<Recipient> getAllRecipients() {
        return recipientRepository.findAll();
    }

    @Override
    public void deleteRecipient(String id) {
        recipientRepository.deleteById(id);
    }
}
