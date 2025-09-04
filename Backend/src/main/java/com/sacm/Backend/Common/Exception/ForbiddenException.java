package com.sacm.Backend.Common.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception representing a forbidden access error (HTTP 403).
 * Thrown when a userJpaEntity attempts to access a resource without sufficient permissions.
 */
@ResponseStatus(HttpStatus.FORBIDDEN)
public class ForbiddenException extends RuntimeException {
  public ForbiddenException(String message) {
    super(message);
  }
}
