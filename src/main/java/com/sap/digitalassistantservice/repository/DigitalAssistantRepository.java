package com.sap.digitalassistantservice.repository;

import com.sap.digitalassistantservice.model.DigitalAssistant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by tharinduruchira on 2024-05-13.
 *
 * @project : digital-assistant-service
 * com.sap.digitalassistantservice.repository
 * <p>
 * Repository interface for Digital Assistant
 */

public interface DigitalAssistantRepository extends JpaRepository<DigitalAssistant, Long> {
    Optional<DigitalAssistant> findByName(String name);
}
