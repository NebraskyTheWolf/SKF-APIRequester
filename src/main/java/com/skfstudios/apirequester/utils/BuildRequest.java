package com.skfstudios.apirequester.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class BuildRequest {
    private final JsonObject REQUEST = new JsonObject();

    public BuildRequest addProperty(String key, String value) {
        this.REQUEST.addProperty(key, value);
        return this;
    }

    public BuildRequest addProperty(String key, Number value) {
        this.REQUEST.addProperty(key, value);
        return this;
    }

    public BuildRequest addProperty(String key, Boolean value) {
        this.REQUEST.addProperty(key, value);
        return this;
    }

    public BuildRequest addProperty(String key, Integer value) {
        this.REQUEST.addProperty(key, value);
        return this;
    }

    public BuildRequest add(String key, JsonElement element) {
        this.REQUEST.add(key, element);
        return this;
    }

    public BuildRequest has(String key, Callback callback) {
        callback.handler(this.REQUEST.has(key));
        return this;
    }

    public BuildRequest get(String key, Callback callback) {
        callback.handler(this.REQUEST.get(key));
        return this;
    }

    public BuildRequest remove(String key) {
        this.remove(key, new Callback() {
            @Override
            public void handler(Object value) {}
        });
        return this;
    }

    public BuildRequest remove(String key, Callback callback) {
        callback.handler(this.REQUEST.remove(key));
        return this;
    }

    public String build() {
        return this.REQUEST.toString();
    }

    public interface Callback {
        public void handler(Object value);
    }
}
