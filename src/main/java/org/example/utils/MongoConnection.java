package org.example.utils;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import io.github.cdimascio.dotenv.Dotenv;
import org.bson.Document;

public class MongoConnection {

    private static final Dotenv dotenv = Dotenv.load();
    private static final String CONNECTION_STRING = dotenv.get("CONNECTION_STRING");
    private static final String DATABASE_NAME = dotenv.get("DATABASE_NAME");

    public static MongoClient client;
    public static MongoDatabase database;
    public static MongoCollection<Document> collection;

    public static MongoCollection<Document> getCollection(String db_collection) {
        if (client == null) {
            client = MongoClients.create(CONNECTION_STRING);
            database = client.getDatabase(DATABASE_NAME);
            collection = database.getCollection(db_collection);
        }
        return collection;
    }

    public static void closeConnection() {
        if (client != null) {
            client.close();
        }
    }
}