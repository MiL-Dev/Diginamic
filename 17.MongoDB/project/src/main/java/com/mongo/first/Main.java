package com.mongo.first;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.bson.Document;


import com.mongo.first.models.Todo;
import com.mongo.first.services.TodoService;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import com.mongodb.client.MongoDatabase;


public class Main {

    static MongoClient client;
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        //String dbConnectionString = ResourceBundle.getBundle("application2", Locale.FRENCH).getString("database"); //Variable d'environnement dans application.propreties
         try{
            client = MongoClients.create("mongodb+srv://root:root@milmongodb.cnhlwfg.mongodb.net/?retryWrites=true&w=majority&appName=MiLMongoDB"); //tentative de connection a la db
            System.out.println(client);
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        MongoDatabase database = client.getDatabase("first"); //Connection a la base de donnee

        //permet de voir les collections(table) dans la database
/*      
        MongoCursor<String> mgCursor = database.listCollectionNames().iterator();
        while(mgCursor.hasNext()){
            System.out.println(mgCursor.next());
        } 
*/

        TodoService.collection = database.getCollection("test"); //Collection = table
        TodoService.read();

        TodoService.create("Je suis le nouveau !");

        List<Todo> listTodo = new ArrayList<>(); //creation d'un liste
        for (Document doc : TodoService.collection.find()) { //boucle de chaque document dans la collection
            Todo occurence = new Todo(doc.get("text").toString(), doc.get("_id").toString()); //cree une nouvelle instance de todo pour chaque occurence de doc
            listTodo.add(occurence); //ajout des occurences a la liste
        }
        
        Todo todo = listTodo.get(0);

        TodoService.update(todo.getId(),"A supprimer");

        TodoService.delete(todo.getId());

    }
}