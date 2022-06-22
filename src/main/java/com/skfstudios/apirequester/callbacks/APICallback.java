package com.skfstudios.apirequester.callbacks;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import java.io.IOException;

public interface APICallback {
    public void result(HttpResponse request, int statusCode) throws IOException, ParseException;
}
