package com.ebanx.heimdall.handlers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import jakarta.annotation.Nullable;

@Component
public class CoreBankingHandler {

    @Nullable
    public CoreBankingResponse handle() {
        HttpClient client = new HttpClient();
        try {

            String response = client.sendGetRequest(webhookUrl);
            Gson gson = new Gson();
            return gson.fromJson(response, CoreBankingResponse.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Value("${heimdall.coreBanking.url}")
    private String webhookUrl;

}
