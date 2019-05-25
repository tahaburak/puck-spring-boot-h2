package com.puck.h2demo.exception;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/** Created by burak on 2019-05-19 */
@Getter
@Setter
public class CustomException extends Exception implements Serializable {

  private static final long serialVersionUID = 330762362587571828L;
  private String errorCode;

  public CustomException(String message) {
    super(message);
  }

  public CustomException(String message, Throwable cause) {
    super(message, cause);
  }

  public CustomException(Throwable cause) {
    super(cause);
  }

  public CustomException(String errorCode, String message) {
    super(message);
    this.errorCode = errorCode;
  }
}
