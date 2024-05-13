package com.sap.digitalassistantservice.common.model;

import java.io.Serializable;

/**
 * Created by tharinduruchira on 2024-05-13.
 *
 * @project : digital-assistant-service
 * com.sap.digitalassistantservice.common
 *
 * Most upper level for all model classes
 */

public abstract class BaseModel implements Serializable {
 public abstract long getId();

 @Override
 public boolean equals(Object o) {
  if (this == o) return true;
  if (o == null || getClass() != o.getClass()) return false;
  boolean eq = getId() == ((BaseModel) o).getId();
  return eq;
 }

 @Override
 public int hashCode() {
  return (int) getId();
 }
}
