package com.skfstudios.apirequester;

import com.google.gson.Gson;
import com.skfstudios.apirequester.callbacks.APICallback;
import com.skfstudios.apirequester.types.APIRoutes;
import com.skfstudios.apirequester.types.APIType;
import com.skfstudios.apirequester.utils.APIConfig;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class APIRequest {
    private final Object[] SYNC = new Object[] {};
    private APIConfig config;
    private List<Header> headers = new CopyOnWriteArrayList<>();
    private HttpClient CLIENT;

    public APIRequest(APIConfig config) {
        this.config = config;
        try {
            if (config.isPayload())
                headers.add(new BasicHeader("GH-Authorisation-Token", config.getAPIToken()));
            headers.add(new BasicHeader("Authorisation", config.getAPIToken()));
            headers.add(new BasicHeader(HttpHeaders.CONTENT_TYPE, "application/json"));
            headers.addAll(config.getHeaders());
            CLIENT = HttpClients
                    .custom()
                    .setDefaultHeaders(headers)
                    .setUserAgent(config.getUserAgent())
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public <T> T handler(APIRoutes route, Object[] args, Type typeOfT) throws IOException, ParseException {
        return this.handler(route, args, typeOfT, null);
    }
    public <T> T handler(APIRoutes route, Object[] args, Type typeOfT, StringEntity entity) throws IOException, ParseException {
        List<T> objects = new CopyOnWriteArrayList<>();

        if (route.type.equals(APIType.GET))
            this.request(route, args, new APICallback() {
                @Override
                public void result(HttpResponse request, int statusCode) throws IOException, ParseException {
                    T object = new Gson().fromJson(new InputStreamReader(request.getEntity().getContent()), typeOfT);
                    objects.add(object);
                }
            }, entity);
        else
            this.request(route, new Object[] {}, new APICallback() {
                @Override
                public void result(HttpResponse request, int statusCode) throws IOException, ParseException {
                    T object = new Gson().fromJson(new InputStreamReader(request.getEntity().getContent()), typeOfT);
                    objects.add(object);
                }
            }, entity);
        return objects.get(0);
    }
    private void request(APIRoutes route, Object[] args, APICallback callback, StringEntity entity) throws IOException, ParseException {
        switch (route.type) {
            case GET: {
                HttpGet request;
                if (args.length > 0)
                    request = new HttpGet(this.config.getEndpoint() + String.format(route.route, args));
                else
                    request = new HttpGet(this.config.getEndpoint() + route.route);
                HttpResponse response = CLIENT.execute(request);
                callback.result(response, response.getStatusLine().getStatusCode());
            }
            break;
            case POST: {
                HttpPost request = new HttpPost(this.config.getEndpoint() + route.route);
                request.setEntity(entity);
                HttpResponse response = CLIENT.execute(request);
                callback.result(response, response.getStatusLine().getStatusCode());
            }
            break;
            case PUT: {
                HttpPut request = new HttpPut(this.config.getEndpoint() + route.route);
                HttpResponse response = CLIENT.execute(request);
                callback.result(response, response.getStatusLine().getStatusCode());
            }
            break;
            case DELETE: {
                HttpDelete request = new HttpDelete(this.config.getEndpoint() + route.route);
                HttpResponse response = CLIENT.execute(request);
                callback.result(response, response.getStatusLine().getStatusCode());
            }
            break;
            case PATCH: {
                HttpPatch request = new HttpPatch(this.config.getEndpoint() + route.route);
                HttpResponse response = CLIENT.execute(request);
                callback.result(response, response.getStatusLine().getStatusCode());
            }
            break;
            default:
                System.out.println(
                        "Invalid request type"
                );
                break;
        }
    }

    public APIConfig getConfig() {
        return config;
    }
}
