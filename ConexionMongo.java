/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crud_mongo;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;


/**
 *
 * @author CLICK
 */
public class ConexionMongo {
    private static MongoClient client;
    
    public static MongoDatabase getDatabase() {
	if (client == null) {
		client = MongoClients.create("mongodb://localhost:27017");
	}
		return client.getDatabase("Tienda");
	}
}
