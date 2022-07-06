package com.example.ownablebackenddevelopment.exception;

import org.zalando.problem.AbstractThrowableProblem;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import org.zalando.problem.DefaultProblem;
import org.zalando.problem.Status;


public class UserNotFoundExcepiton   extends AbstractThrowableProblem {

    private static final long serialVersionUID = 1L;

    private  String entityName;

    private  String errorKey;


    public UserNotFoundExcepiton (String defaultMessage, String entityName, String errorKey) {
        this(DefaultProblem.DEFAULT_TYPE, defaultMessage, entityName, errorKey);
    }


    public UserNotFoundExcepiton(URI type, String defaultMessage, String entityName, String errorKey) {
        super(type, defaultMessage, Status.BAD_REQUEST, null, null, null, getAlertParameters(entityName, errorKey));
        this.entityName = entityName;
        this.errorKey = errorKey;
    }

    public String getEntityName(){
        return entityName;
    }

    public String getErrorKey () {
        return errorKey;
    }

    private static Map<String, Object> getAlertParameters (String entityName, String errorKey) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("message","error." + errorKey);
        parameters.put("params", entityName);
        return parameters;
    }
}
