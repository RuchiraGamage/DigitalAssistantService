package com.sap.digitalassistantservice.common.service;

import com.sap.digitalassistantservice.common.model.BaseEntity;
import com.sap.digitalassistantservice.common.util.SAPException;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by tharinduruchira on 2024-05-13.
 *
 * @project : digital-assistant-service
 * com.sap.digitalassistantservice.common
 *
 * Definition of base CRUD services
 * @param <Entity> Entity type
 */

public interface BaseCrudService<Entity extends BaseEntity> extends BaseService<Entity> {

 /**
  * Get JPA repository of selected service
  * @return JPA repository
  */
 JpaRepository<Entity, Long> getRepository();

 /**
  * Save an entity
  * @param entity Entity to be saved
  * @return Saved entity
  * @throws SAPException Exception if occurred
  */
 Entity save(Entity entity) throws SAPException;

 /**
  * Get entity by it's ID
  * @param id Entity ID
  * @return Entity
  * @throws SAPException Exception if occurred
  */
 Entity getById(long id) throws SAPException;
}

