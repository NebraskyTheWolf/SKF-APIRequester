package com.skfstudios.apirequester.templates.dataset;

public class Payload {

    private boolean status;
    private String message;
    private Object data;

    private int code;
    private String error;


    public Object getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public String getError() {
        return error;
    }

    public boolean isStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Payload{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", code=" + code +
                ", error='" + error + '\'' +
                '}';
    }
}
