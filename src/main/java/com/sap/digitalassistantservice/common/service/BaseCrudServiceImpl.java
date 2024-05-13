package com.sap.digitalassistantservice.common.service;

import com.sap.digitalassistantservice.common.model.BaseEntity;
import com.sap.digitalassistantservice.common.util.SAPException;
import com.sap.digitalassistantservice.common.util.SAPLogger;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by tharinduruchira on 2024-05-13.
 *
 * @project : digital-assistant-service
 * com.sap.digitalassistantservice.common
 */

public abstract class BaseCrudServiceImpl<Entity extends BaseEntity> implements BaseCrudService<Entity> {

    private JpaRepository<Entity, Long> jpaRepository;

    public BaseCrudServiceImpl(JpaRepository<Entity, Long> jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public JpaRepository<Entity, Long> getRepository() {
        return jpaRepository;
    }

    @Override
    public Entity save(Entity entity) throws SAPException {
        try {
            jpaRepository.save(entity);
            return entity;
        } catch (Exception e) {
            SAPLogger.error(e);
            throw SAPException.makeServerException();
        }
    }

    @Override
    public Entity getById(long id) throws SAPException {
        Entity entity = jpaRepository.findById(id).orElse(null);
        if (entity == null) {
            throw SAPException.makeNotFoundException();
        }

        return entity;
    }
}
