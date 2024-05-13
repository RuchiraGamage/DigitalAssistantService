package com.sap.digitalassistantservice.common.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Created by tharinduruchira on 2024-05-13.
 *
 * @project : digital-assistant-service
 * com.sap.digitalassistantservice.common
 *
 * Custom exception class for application
 */

@Getter
@Setter
public class SAPException extends Exception {

 private int errorCode;
 private String errorMsg;
 private List<Error> errors;

 public static SAPException makeServerException() {
  return makeException(ErrorResponse.STATUS_SERVER_ERROR, ErrorResponse.MSG_SERVER_ERROR);
 }

 public static SAPException makeException(int code, String msg) {
  SAPException sapException = new SAPException();
  sapException.setErrorCode(code);
  sapException.setErrorMsg(msg);
  return sapException;
 }

 public static SAPException makeNotFoundException() {
  return makeException(ErrorResponse.STATUS_NOT_FOUND, ErrorResponse.MSG_NOT_FOUND);
 }

 public void printLog() {
  SAPLogger.errorMsg(this.errorMsg);
 }

 public ResponseEntity makeResponse() {
  ErrorResponse tResponseModel = new ErrorResponse(this.errorCode, this.errorMsg);
  tResponseModel.setErrors(errors);
  SAPLogger.responseBody(tResponseModel);
  return new ResponseEntity<>(tResponseModel, HttpStatus.OK);
 }
}

