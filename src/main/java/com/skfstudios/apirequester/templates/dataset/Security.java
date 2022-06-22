package com.skfstudios.apirequester.templates.dataset;

public class Security {
    private boolean status;
    private String code;
    private String message;

    public String getMessage() {
        return message;
    }

    public boolean isStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }
}
