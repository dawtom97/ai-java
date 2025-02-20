package org.example;

import org.example.services.HuggingFaceApiService;

import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<String,String> result= HuggingFaceApiService.generate("How are you?");
        System.out.println(result.get("content"));
    }

}
