package com.sap.digitalassistantservice.common.util;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by tharinduruchira on 2024-05-13.
 *
 * @param <T> Entity type
 * @project : digital-assistant-service
 * com.sap.digitalassistantservice.common
 * <p>
 * Model class for success response
 */

@Getter
@Setter
@ToString
public class SuccessResponse<T> extends ResponseModel {

    public static final int STATUS_SUCCESS = 1000;
    public static final String MSG_SUCCESS = "Success";


    /**
     * Response data object
     */
    private T data;

    public SuccessResponse(T data) {
        this.code = STATUS_SUCCESS;
        this.msg = MSG_SUCCESS;
        this.data = data;
    }

    public SuccessResponse() {
        new SuccessResponse<T>(null);
    }

    public SuccessResponse(String msg, T data) {
        super(STATUS_SUCCESS, msg);
        this.data = data;
    }
}

