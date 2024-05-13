package com.sap.digitalassistantservice.common.util;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tharinduruchira on 2024-05-13.
 *
 * @project : digital-assistant-service
 * com.sap.digitalassistantservice.common
 *
 * Model class for error responses
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class ErrorResponse extends ResponseModel {

 public static final int STATUS_SERVER_ERROR = 5000;
 public static final int STATUS_NOT_FOUND = 4000;
 public static final int STATUS_INVALID_PARAMS = 4100;

 public static final String MSG_SERVER_ERROR = "Internal server error";
 public static final String MSG_NOT_FOUND = "Not found";
 public static final String MSG_INVALID_PARAMS = "Invalid parameters";
 public static final String MSG_ALREADY_EXISTS = "Already exists";

 /**
  * List of errors
  */
 private List<Error> errors;

 public ErrorResponse(int code, String msg, List<Error> errors) {
  this.code = code;
  this.msg = msg;
  this.errors = errors;
 }

 public ErrorResponse(int code, String msg, Error error) {
  this.code = code;
  this.msg = msg;
  this.errors = new ArrayList<>();
  this.errors.add(error);
 }

 public ErrorResponse(int code, String msg) {
  this.code = code;
  this.msg = msg;
 }

 public ErrorResponse() {
 }
}
