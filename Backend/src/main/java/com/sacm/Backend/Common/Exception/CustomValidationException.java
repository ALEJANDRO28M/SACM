package com.sacm.Backend.Common.Exception;

public class CustomValidationException extends RuntimeException {
  public CustomValidationException(String message) {
    super(message);
  }
}
