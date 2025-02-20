package org.example;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.example.services.AiAnswerService;
import org.example.services.HuggingFaceApiService;
import org.example.utils.MongoConnection;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        MongoCollection<Document> answers = MongoConnection.getCollection("answers");
        AiAnswerService answerService = new AiAnswerService(answers);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Zadaj mi pytanie: ");
        String prompt = scanner.nextLine();
        Map<String,String> result= HuggingFaceApiService.generate(prompt);

        answerService.createAiAnswer(result);

    }

}
