package com.sap.digitalassistantservice.model;

import com.sap.digitalassistantservice.common.model.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by tharinduruchira on 2024-05-13.
 *
 * @project : digital-assistant-service
 * com.sap.digitalassistantservice.model
 *
 * Database entity class for Digital Assistant
 */

@Getter
@Setter
@ToString
@Entity
@Table(name = "tbl_digital_assistant")
public class DigitalAssistant extends BaseEntity {

 private String name;

 private String text;
}
