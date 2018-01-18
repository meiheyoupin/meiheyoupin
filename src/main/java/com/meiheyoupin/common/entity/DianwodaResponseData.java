package com.meiheyoupin.common.entity;


public class DianwodaResponseData {
    private String errorCode;
    private String message;
    private boolean success;
    private result result;

    public DianwodaResponseData() {
    }

    public DianwodaResponseData(String errorCode, String message, boolean success) {
        this.errorCode = errorCode;
        this.message = message;
        this.success = success;
    }

    public DianwodaResponseData(String errorCode, boolean success, DianwodaResponseData.result result) {
        this.errorCode = errorCode;
        this.success = success;
        this.result = result;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public DianwodaResponseData.result getResult() {
        return result;
    }

    public void setResult(DianwodaResponseData.result result) {
        this.result = result;
    }

    class result{

    }
}
