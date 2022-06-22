package com.skfstudios.apirequester.utils;

import org.apache.http.Header;

import javax.net.ssl.SSLException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class APIConfig {
    private String ENDPOINT = "https://api.skf-studios.com";
    private String API_TOKEN = "0";
    private String USER_AGENT = "API 1.0.0/routes";
    private String API_SIG = "0";
    private List<Header> headers = new CopyOnWriteArrayList<>();
    private boolean payload = false;
    private String API_VERSION = "1.0.0";
    private String API_NAME = "No name";

    public APIConfig setAPIToken(String token) throws SSLException {
        this.API_TOKEN = token;
        return this;
    }

    public APIConfig setEndpoint(String endpoint) throws SSLException {
        if (endpoint.contains("https://"))
            this.ENDPOINT = endpoint;
        else
            throw new SSLException("Not a HTTPS URL, Not allowed.");
        return this;
    }

    public APIConfig setUserAgent(String agent) throws SSLException {
        this.USER_AGENT = agent;
        return this;
    }

    public APIConfig setAPISignature(String sig) throws SSLException {
        this.API_SIG = sig;
        return this;
    }

    public APIConfig setHeaders(List<Header> headers) throws SSLException {
        this.headers.addAll(headers);
        return this;
    }

    public APIConfig setPayload(boolean allowPayload) throws SSLException {
        this.payload = allowPayload;
        return this;
    }

    public APIConfig setAPIVersion(String apiVersion) throws SSLException {
        this.API_VERSION = apiVersion;
        return this;
    }

    public APIConfig setAPIName(String apiName) throws SSLException {
        this.API_NAME = apiName;
        return this;
    }

    public List<Header> getHeaders() {
        return headers;
    }

    public String getAPIName() {
        return API_NAME;
    }

    public String getAPISig() {
        return API_SIG;
    }

    public String getAPIVersion() {
        return API_VERSION;
    }

    public String getEndpoint() {
        return ENDPOINT;
    }

    public String getUserAgent() {
        return USER_AGENT;
    }

    public boolean isPayload() {
        return payload;
    }

    public String getAPIToken() {
        return API_TOKEN;
    }
}
