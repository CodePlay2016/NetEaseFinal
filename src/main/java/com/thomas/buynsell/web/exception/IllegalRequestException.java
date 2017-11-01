package com.thomas.buynsell.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "illegal length of title or body")
public class IllegalRequestException extends RuntimeException {
}
