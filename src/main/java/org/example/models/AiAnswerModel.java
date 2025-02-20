package org.example.models;

public class AiAnswerModel {

    private String content;
    private String timestamp;

    public AiAnswerModel(String content, String timestamp) {
        this.content = content;
        this.timestamp = timestamp;
    }

    public AiAnswerModel() {}

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "AiAnswerModel{" +
                "content='" + content + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }

}
