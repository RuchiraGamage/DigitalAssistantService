package com.sap.digitalassistantservice.common.util;

import com.sap.digitalassistantservice.common.model.BaseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Created by tharinduruchira on 2024-05-13.
 *
 * @project : digital-assistant-service
 * com.sap.digitalassistantservice.common
 * <p>
 * Helper class for controllers to build responses
 */

public class ResponseBuilder {
    /**
     * Make response according to given params
     *
     * @param code Response code
     * @param msg  Respone message
     * @param data response body
     * @param <T>  Response entity type
     * @return Response
     */
    protected <T extends BaseModel> ResponseEntity<ResponseModel> makeFinalResponse(int code, String msg, T data) {
        ResponseModel responseModel;
        if (code == SuccessResponse.STATUS_SUCCESS) {
            responseModel = new SuccessResponse<>(msg, data);
        } else {
            responseModel = new ErrorResponse(code, msg);
        }

        SAPLogger.responseBody(responseModel);
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    /**
     * make response object for success result
     *
     * @param data response body
     * @param <T>  Entity type
     * @return Response
     */
    protected <T extends BaseModel> ResponseEntity<ResponseModel> makeSuccessResponse(T data) {
        return makeFinalResponse(SuccessResponse.STATUS_SUCCESS, SuccessResponse.MSG_SUCCESS, data);
    }

    /**
     * Make error response for invalid parameters
     *
     * @return Response
     */
    protected ResponseEntity<ResponseModel> makeInvalidParamsResponse() {
        return makeInvalidParamsResponse(ErrorResponse.MSG_INVALID_PARAMS);
    }

    /**
     * Make error response for invalid parameters
     *
     * @return Response
     */
    protected ResponseEntity<ResponseModel> makeAlreadyExistsResponse() {
        return makeInvalidParamsResponse(ErrorResponse.MSG_ALREADY_EXISTS);
    }

    /**
     * Make error response for invalid parameters
     *
     * @param msg Message
     * @return Response
     */
    protected ResponseEntity<ResponseModel> makeInvalidParamsResponse(String msg) {
        return makeFinalResponse(ErrorResponse.STATUS_INVALID_PARAMS, msg, null);
    }

    /**
     * Make error response for not found entities
     *
     * @return Response
     */
    protected ResponseEntity makeNotFoundResponse() {
        return makeNotFoundResponse(ErrorResponse.MSG_NOT_FOUND);
    }

    /**
     * Make error response for not found entities
     *
     * @param msg Message
     * @return Response
     */
    protected ResponseEntity makeNotFoundResponse(String msg) {
        return makeFinalResponse(ErrorResponse.STATUS_NOT_FOUND, msg, null);
    }

    /**
     * Make error response for server side errors
     *
     * @return Response
     */
    protected ResponseEntity<ResponseModel> makeServerErrorResponse() {
        return makeFinalResponse(ErrorResponse.STATUS_SERVER_ERROR, ErrorResponse.MSG_SERVER_ERROR, null);
    }

    /**
     * make success response for saved entity
     *
     * @param data Saved entity
     * @param <T>  Entity type
     * @return Response
     */
    protected <T extends BaseModel> ResponseEntity<ResponseModel> makeResponseForSave(T data) {
        if (data == null) {
            return makeServerErrorResponse();
        }

        if (data.getId() == 0) {
            return makeNotFoundResponse();
        }

        return makeSuccessResponse(data);
    }

    /**
     * Make success response for get entity
     *
     * @param data Returned entity
     * @param <T>  Entity type
     * @return Response
     */
    protected <T extends BaseModel> ResponseEntity<ResponseModel> makeResponseForGet(T data) {
        if (data == null) {
            return makeServerErrorResponse();
        }

        if (data.getId() == 0) {
            return makeNotFoundResponse();
        }

        return makeSuccessResponse(data);
    }

}

