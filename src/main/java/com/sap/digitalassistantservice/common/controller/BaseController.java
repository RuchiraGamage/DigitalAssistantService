package com.sap.digitalassistantservice.common.controller;

import com.sap.digitalassistantservice.common.model.BaseEntity;
import com.sap.digitalassistantservice.common.util.Globals;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * Created by tharinduruchira on 2024-05-13.
 *
 * @param <Entity> Entity type selected
 * @project : digital-assistant-service
 * com.sap.digitalassistantservice.common
 * <p>
 * Most upper level interface of controllers
 */

@CrossOrigin(origins = Globals.ALLOWED_ORIGINS)
public interface BaseController<Entity extends BaseEntity> {
}
