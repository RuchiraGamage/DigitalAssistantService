package com.sap.digitalassistantservice.common.controller;

import com.sap.digitalassistantservice.common.service.BaseCrudService;
import com.sap.digitalassistantservice.common.model.BaseEntity;
import com.sap.digitalassistantservice.common.util.ResponseBuilder;
import com.sap.digitalassistantservice.common.util.SAPException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by tharinduruchira on 2024-05-13.
 *
 * @param <Entity> Entity type selected
 * @project : digital-assistant-service
 * com.sap.digitalassistantservice.common
 * <p>
 * Implementation of {{@link BaseCrudController}}
 */

public abstract class BaseCrudControllerImpl<Entity extends BaseEntity> extends ResponseBuilder implements BaseCrudController<Entity> {

    private BaseCrudService<Entity> baseCrudService;

    public BaseCrudControllerImpl(BaseCrudService<Entity> baseCrudService) {
        this.baseCrudService = baseCrudService;
    }

    @Override
    public ResponseEntity add(@RequestBody Entity entity) {
        try {
            if (!isValidAddRequest(entity)) {
                return makeInvalidParamsResponse();
            }

            return makeResponseForSave(baseCrudService.save(entity));
        } catch (SAPException e) {
            e.printLog();
            return e.makeResponse();
        }
    }

    /**
     * Check whether the request object contains valid fields or not
     *
     * @param entity Entity to be validated
     * @return Valid or not status
     */
    protected boolean isValidAddRequest(Entity entity) {
        return entity != null;
    }

    @Override
    public ResponseEntity getById(@PathVariable long id) {
        if (id < 1) {
            return makeInvalidParamsResponse();
        }

        try {
            return makeResponseForGet(baseCrudService.getById(id));
        } catch (SAPException e) {
            e.printLog();
            return e.makeResponse();
        }
    }
}

