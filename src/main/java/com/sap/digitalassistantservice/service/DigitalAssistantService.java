package com.sap.digitalassistantservice.service;

import com.sap.digitalassistantservice.common.service.BaseCrudServiceImpl;
import com.sap.digitalassistantservice.common.util.ErrorResponse;
import com.sap.digitalassistantservice.common.util.SAPException;
import com.sap.digitalassistantservice.common.util.SAPLogger;
import com.sap.digitalassistantservice.model.DigitalAssistant;
import com.sap.digitalassistantservice.repository.DigitalAssistantRepository;
import org.springframework.stereotype.Service;

/**
 * Created by tharinduruchira on 2024-05-13.
 *
 * @project : digital-assistant-service
 * com.sap.digitalassistantservice.service
 * <p>
 * <p>
 * Service class for Digital Assistant
 */

@Service
public class DigitalAssistantService extends BaseCrudServiceImpl<DigitalAssistant> {

    private final DigitalAssistantRepository digitalAssistantRepository;

    public DigitalAssistantService(DigitalAssistantRepository digitalAssistantRepository) {
        super(digitalAssistantRepository);
        this.digitalAssistantRepository = digitalAssistantRepository;
    }

    public boolean checkDigitalAssistantAlreadyExistsByName(String name) throws SAPException {
        try {
            return digitalAssistantRepository.findByName(name).isPresent();
        } catch (Exception e) {
            SAPLogger.error(e);
            throw SAPException.makeServerException();
        }
    }

    public DigitalAssistant getAssistanceByName(String assistantName) throws SAPException {
        try {
            return digitalAssistantRepository.findByName(assistantName).get();
        } catch (Exception e) {
            SAPLogger.error(e);
            throw SAPException.makeException(ErrorResponse.STATUS_NOT_FOUND, e.getMessage());
        }
    }
}
