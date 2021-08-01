package com.hermes.webservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "notification not found")
public class NotificationNotFoundException extends RuntimeException {
}
