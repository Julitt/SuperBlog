package com.example.postserver.postServer.comment;

/**
 * Created by Julitt on 15.06.2017.
 */
public class Comment {

    long id;
    String content;

    public  Comment(){

    }

    public Comment(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
