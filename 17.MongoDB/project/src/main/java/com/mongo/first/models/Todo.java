package com.mongo.first.models;

public class Todo {
    String id;
    String text;
    
    public Todo(String text, String... id) {

        this.text = text;
        if(id.length > 0){
            this.id = id[0];
        }
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Todo [id=" + id + ", text=" + text + "]";
    }
    
}
