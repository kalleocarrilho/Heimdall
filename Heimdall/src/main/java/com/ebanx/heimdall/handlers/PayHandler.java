package com.ebanx.heimdall.handlers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import jakarta.annotation.Nullable;

@Component
public class PayHandler {

    @Nullable
    public PayResponse handle() {
        HttpClient client = new HttpClient();
        try {

            String response = client.sendGetRequest(webhookUrl);
            Gson gson = new Gson();
            return gson.fromJson(response, PayResponse.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Value("${heimdall.pay.url}")
    private String webhookUrl;

}
