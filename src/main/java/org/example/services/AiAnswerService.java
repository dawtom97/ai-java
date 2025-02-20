package org.example.services;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.example.models.AiAnswerModel;

import java.util.Map;

public class AiAnswerService {

    private MongoCollection<Document> answers;

    public AiAnswerService(MongoCollection<Document> answers) {
        this.answers = answers;
    }

    public void createAiAnswer(Map<String,String> model) {
        try {
            AiAnswerModel answerData = new AiAnswerModel(
                    model.get("content"),
                    model.get("timestamp"));

            Document doc = new Document("content", answerData.getContent())
                .append("timestamp", answerData.getTimestamp());

            this.answers.insertOne(doc);
            System.out.println("Dodano nową odpowiedź AI");

        } catch (Exception e) {
            System.out.println(e);
        }
    }


}
