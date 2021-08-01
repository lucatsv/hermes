package com.hermes.webservice.services.recipient;

import com.hermes.webservice.models.Recipient;

import java.util.List;

public interface RecipientService {
    public String createRecipient(Recipient recipient);

    public Recipient findRecipient(String id);

    public List<Recipient> getAllRecipients();

    public void deleteRecipient(String id);
}
