package com.mongo.first.services;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.mongo.first.models.Todo;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;

public class TodoService {
    public static MongoCollection<Document> collection;
    

    public static void create(String text){
        Todo todo = new Todo(text);  // cree un instance de todo
        Document document = new Document();      // instance d'un document
        document.append("_id", new ObjectId().toHexString()); // ajout id en hexadecimal
        document.append("text", todo.getText()); // ajout du text de la todo
        InsertOneResult insertOneResult = collection.insertOne(document);
        System.out.println(insertOneResult.getInsertedId()); // get de l'id du nouveau documment qu'on viens d'inserer
        read();
    }
    public static void update(String id, String newText){
        Bson filter = Filters.eq("_id", id); //cree un filtre pour recuperer la document par rapport a l'id !ATTENTION - ICI METTRE UN OBJECTID
        Bson updater = Updates.combine(Updates.set("text", newText)); //preparation d'un changement de cette index et sont contenue
        UpdateResult updateResult = collection.updateOne(filter, updater);//ici on fait la modification avec le filter(id) et le updater(lamodif)
        read();
    }
    public static void delete(String id){
        Bson filterToDelete = Filters.eq("_id", id); //configure le filtre pour supprimer la todo selon l'id
        DeleteResult deleteResult = collection.deleteOne(filterToDelete); //Supprimer le document qui a cette id 
        read();
    }
    public static void read(){
        if(collection.countDocuments() <= 0){
            System.out.println("Il n'y a rien dans la collection");
        }
        collection.find().forEach((doc) -> System.out.println(doc.toJson())); //find les cellules de la table(colonne)
    }
}
