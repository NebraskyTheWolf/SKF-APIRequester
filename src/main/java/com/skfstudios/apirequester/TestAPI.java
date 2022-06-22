package com.skfstudios.apirequester;

import com.skfstudios.apirequester.templates.dataset.Payload;
import com.skfstudios.apirequester.types.APIRoutes;
import com.skfstudios.apirequester.utils.APIConfig;
import com.skfstudios.apirequester.utils.BuildRequest;
import org.apache.http.entity.StringEntity;

import javax.net.ssl.SSLException;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestAPI {
    private static final APIRequest request;

    static {
        try {
            request = new APIRequest(
                    new APIConfig()
                            .setAPIName("APINAME")
                            .setAPIVersion("VERSION")
                            .setAPISignature("INTEGRITY_PUBLIC_FINGERPRINT")
                            .setPayload(true)
                            .setAPIToken("SKF_TOKEN")
                            .setEndpoint("ENDPOINT_URL")
            );
        } catch (SSLException e) {
            throw new RuntimeException(e);
        }
    }

    public static APIRequest getRequest() {
        return request;
    }

    public static void main(String[] args) throws Exception {
        Payload json = request.handler(APIRoutes.PAYLOAD, new Object[] {}, Payload.class, new StringEntity(
                new BuildRequest()
                        .addProperty("key", "TEST@BAN")
                        .addProperty("data", "{}")
                        .build()
        ));
        System.err.println("==========================================");
        System.err.println("Status: " + (json.isStatus() ? "ACCEPTED." : "REJECTED."));
        System.err.println("Messages: " + (json.getMessage() == null ? "No message." : json.getMessage()));
        System.err.println("Data: " + (json.getData() == null ? "No data." : json.getData()));
        System.err.println("Code: " + (json.getCode() == 0 ? "Unknown error" : json.getCode()));
        System.err.println("Error: " + (json.getError() == null ? "No error." : json.getError()));
        System.err.println("==========================================");
    }
}
