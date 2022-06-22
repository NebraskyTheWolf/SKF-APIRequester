package com.skfstudios.apirequester.templates.errors;

import com.skfstudios.apirequester.templates.base.ErrorHelper;
import com.skfstudios.apirequester.types.APISide;

public class ServerError extends ErrorHelper {
    @Override
    public String getError() {
        return super.getError();
    }

    @Override
    public boolean isStatus() {
        return super.isStatus();
    }

    public String getSide() {
        return APISide.SERVER.getSide();
    }
}
