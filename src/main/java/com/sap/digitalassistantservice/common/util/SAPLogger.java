package com.sap.digitalassistantservice.common.util;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by tharinduruchira on 2024-05-13.
 *
 * @project : digital-assistant-service
 * com.sap.digitalassistantservice.common
 *
 * Custom logger class for application
 */

public class SAPLogger {
 private static final Logger LOGGER_RESPONSE = Logger.getLogger("SAP_RESPONSE_BODY");

 /**
  * Log response body
  * @param object Response body
  */
 public static void responseBody(Object object) {
  if (object == null) {
   LOGGER_RESPONSE.info("Null Object");
   return;
  }

  LOGGER_RESPONSE.info(object.toString());
 }

 /**
  * Log an exception
  * @param e Exception
  */
 public static void error(Exception e) {
  Logger.getLogger("Error").log(Level.WARNING, e.getMessage());
  e.printStackTrace();
 }

 /**
  * Log an error message
  * @param msg Error message
  */
 public static void errorMsg(String msg) {
  Logger.getLogger("Error").log(Level.WARNING, msg);
 }
}


