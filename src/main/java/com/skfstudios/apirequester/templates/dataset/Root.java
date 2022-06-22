package com.skfstudios.apirequester.templates.dataset;

public class Root {
    private String apiVersion;
    private String apiAuthor;
    private String apiName;
    private String apiSig;
    private Object apiOptions;

    @Override
    public String toString() {
        return "TestJson{" +
                "apiVersion='" + apiVersion + '\'' +
                ", apiAuthor='" + apiAuthor + '\'' +
                ", apiName='" + apiName + '\'' +
                ", apiSig='" + apiSig + '\'' +
                ", apiOptions=" + apiOptions +
                '}';
    }

    public Object getApiOptions() {
        return apiOptions;
    }

    public String getApiAuthor() {
        return apiAuthor;
    }

    public String getApiName() {
        return apiName;
    }

    public String getApiSig() {
        return apiSig;
    }

    public String getApiVersion() {
        return apiVersion;
    }
}
