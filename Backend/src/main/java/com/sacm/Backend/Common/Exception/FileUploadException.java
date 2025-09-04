package com.sacm.Backend.Common.Exception;

/**
 * Exception thrown when an error occurs during file upload.
 * This can be due to I/O issues, invalid file formats, or service failures.
 */
public class FileUploadException extends RuntimeException {
  public FileUploadException(String message, Throwable cause) {
    super(message, cause);
  }

  public FileUploadException(String message) {
    super(message);
  }
}