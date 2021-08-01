package com.hermes.webservice.controllers;

import com.hermes.webservice.models.Recipient;
import com.hermes.webservice.services.recipient.RecipientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipientController {

    @Autowired
    RecipientService recipientService;

    @PostMapping("recipient")
    public String createRecipient(@RequestBody Recipient recipient) {
        return recipientService.createRecipient(recipient);
    }

    @GetMapping("recipient/{id}")
    public Recipient getRecipient(@PathVariable String id) {
        System.out.println("UUID: " + id);
        Recipient recipient = recipientService.findRecipient(id);
        return recipient;
    }

    @GetMapping("recipients")
    public List<Recipient> getAllRecipients(){
        return recipientService.getAllRecipients();
    }

    @DeleteMapping("recipients/{id}")
    public void deleteRecipient(@PathVariable String id) {
        recipientService.deleteRecipient(id);
    }


}
