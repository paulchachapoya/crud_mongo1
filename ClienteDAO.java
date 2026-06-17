/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crud_mongo;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author CLICK
 */
public class ClienteDAO {
     private MongoCollection<Document> coleccion;
     
public ClienteDAO() {
	MongoDatabase db = ConexionMongo.getDatabase();
	coleccion = db.getCollection("Clientes");
}
public void insertar(String nombre, String ciudad, int edad) {
	Document doc = new Document("nombre", nombre)
	.append("ciudad", ciudad)
	.append("edad", edad);
	coleccion.insertOne(doc);
}
public Iterable<Document> listar() {
	return coleccion.find();
}
public void actualizar(String id, String nombre, String ciudad, int edad) {
	coleccion.updateOne(
	new Document("_id", new ObjectId(id)),
	//new Document("nombre", nombre),
	new Document("$set", new Document("nombre", nombre)
	                        .append("ciudad", ciudad)
	                        .append("edad", edad))
	);
}

public void eliminar(String id) {
    coleccion.deleteOne(new Document("_id", new ObjectId(id)));
}     
}
