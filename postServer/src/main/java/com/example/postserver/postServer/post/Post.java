package com.example.postserver.postServer.post;
import com.example.postserver.postServer.comment.Comment;

import java.util.HashMap;

/**
 * Created by Julitt on 15.06.2017.
 */
public class Post {

    long id;
    String title;
    String content;
    HashMap<Long, Comment> comments;
    static long idForComment;

    public Post() {
        if(this.getTitle()==null)
            this.setTitle("Brak tytułu");
        comments = new HashMap<>();
        idForComment = 0;
    }

    public Post(long id, String title, String content){
        this.id = id;
        this.title = title;
        this.content = content;
        this.comments = new HashMap<>();
    }

    public Comment addComment(Comment comment){
        comment.setId(idForComment++);
        return comments.put(comment.getId(), comment);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public HashMap<Long, Comment> getComments() {
        return comments;
    }

    public void setComments(HashMap<Long, Comment> comments) {
        this.comments = comments;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
