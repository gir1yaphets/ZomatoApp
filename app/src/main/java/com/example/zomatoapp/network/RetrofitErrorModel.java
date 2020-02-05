package com.example.zomatoapp.network;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class RetrofitErrorModel implements Serializable {
    private List<ErrorModel> errors;

    public RetrofitErrorModel() {
        this.errors = new ArrayList<>();
        //for default error
        ErrorModel errorModel = new ErrorModel();
        this.errors.add(errorModel);
    }

    public List<ErrorModel> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorModel> errors) {
        this.errors = errors;
    }

    public static class ErrorModel implements Serializable {

        private String code;
        private String message;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

}