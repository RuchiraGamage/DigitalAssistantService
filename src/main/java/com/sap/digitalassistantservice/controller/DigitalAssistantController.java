package com.sap.digitalassistantservice.controller;

import com.sap.digitalassistantservice.common.controller.BaseCrudControllerImpl;
import com.sap.digitalassistantservice.common.util.SAPException;
import com.sap.digitalassistantservice.common.util.SuccessResponse;
import com.sap.digitalassistantservice.model.DigitalAssistant;
import com.sap.digitalassistantservice.service.DigitalAssistantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by tharinduruchira on 2024-05-13.
 *
 * @project : digital-assistant-service
 * com.sap.digitalassistantservice.controller
 * <p>
 * Controller class for Digital Assistant
 */

@RestController
@RequestMapping("/digital-assistant")
public class DigitalAssistantController extends BaseCrudControllerImpl<DigitalAssistant> {

    private final DigitalAssistantService digitalAssistantService;

    @Autowired
    public DigitalAssistantController(DigitalAssistantService digitalAssistantService) {
        super(digitalAssistantService);
        this.digitalAssistantService = digitalAssistantService;
    }

    @Override
    public ResponseEntity<?> add(@RequestBody DigitalAssistant entity) {
        try {
            if (digitalAssistantService.checkDigitalAssistantAlreadyExistsByName(entity.getName())) {
                return makeAlreadyExistsResponse();
            }
            return super.add(entity);
        } catch (SAPException e) {
            e.printLog();
            return e.makeResponse();
        }
    }

    @GetMapping("/send")
    ResponseEntity<?> getAssistanceByName(@RequestParam(name = "assistant-name") String assistantName) {
        try {
            return new ResponseEntity<>(new SuccessResponse<>(SuccessResponse.MSG_SUCCESS, digitalAssistantService.getAssistanceByName(assistantName).getText()), HttpStatus.OK);
        } catch (SAPException e) {
            e.printLog();
            return e.makeResponse();
        }
    }

    @Override
    protected boolean isValidAddRequest(DigitalAssistant entity) {
        return entity != null && entity.getName() != null && entity.getText() != null && !entity.getName().isEmpty() && !entity.getText().isEmpty();
    }
}
