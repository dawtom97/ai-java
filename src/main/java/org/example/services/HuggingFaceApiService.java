package org.example.services;

import com.google.gson.Gson;
import io.github.cdimascio.dotenv.Dotenv;
import okhttp3.*;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HuggingFaceApiService {
    public static final Dotenv dotenv = Dotenv.load();
    private static final String API_KEY = dotenv.get("HUGGING_FACE_API_KEY");
    public static final String API_URL = dotenv.get("HUGGING_FACE_URL");

    public static Map<String, String> generate(String prompt) {
        try {
            HashMap json = new HashMap();
            json.put("inputs",prompt);
            String gson = new Gson().toJson(json);

            OkHttpClient client = new OkHttpClient();

            RequestBody body = RequestBody.create(gson, MediaType.get("application/json"));

            Request request = new Request.Builder()
                    .url(API_URL)
                    .addHeader("Authorization", "Bearer " + API_KEY)
                    .addHeader("Content-Type", "application/json")
                    .post(body)
                    .build();

            Response response = client.newCall(request).execute();

            String responseBody = response.body().string();

            List<Map<String, Object>> mapList = new Gson().fromJson(responseBody, List.class);
            String content = mapList.isEmpty() ? "" : mapList.get(0).toString();

            Map<String, String> result = new HashMap<>();
            result.put("content", content);
            result.put("timestamp", Instant.now().toString());

            return result;

        } catch (Exception error) {
            error.printStackTrace();
            return new HashMap<>();
        }


    }


}
