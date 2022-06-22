package com.skfstudios.apirequester.templates.errors;

import com.skfstudios.apirequester.templates.base.ErrorHelper;

public class AuthenticationError extends ErrorHelper {
    private int code;
    private String message;

    @Override
    public String getError() {
        return super.getError();
    }

    @Override
    public boolean isStatus() {
        return super.isStatus();
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
