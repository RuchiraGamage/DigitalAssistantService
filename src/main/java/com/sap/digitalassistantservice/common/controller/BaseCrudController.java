package com.sap.digitalassistantservice.common.controller;

import com.sap.digitalassistantservice.common.model.BaseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by tharinduruchira on 2024-05-13.
 *
 * @project : digital-assistant-service
 * com.sap.digitalassistantservice.common
 * CRUD controller definition
 * @param <Entity> Entity type selected
 */

public interface BaseCrudController <Entity extends BaseEntity> extends BaseController<Entity> {

 /**
  * Save new entity
  * @param entity Entity to be saved
  * @return Response with status
  */
 @PostMapping
 ResponseEntity add(@RequestBody Entity entity);

 /**
  * Get entity by ID
  * @param id Entity ID
  * @return Response with status
  */
 @GetMapping("/{id}")
 ResponseEntity getById(@PathVariable long id);
}
