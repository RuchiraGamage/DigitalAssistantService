package com.sap.digitalassistantservice.common.util;

import lombok.*;

import java.io.Serializable;

/**
 * Created by tharinduruchira on 2024-05-13.
 *
 * @project : digital-assistant-service
 * com.sap.digitalassistantservice.common
 * <p>
 * Base class of response model
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class ResponseModel implements Serializable {

    protected int code;
    protected String msg;
}
