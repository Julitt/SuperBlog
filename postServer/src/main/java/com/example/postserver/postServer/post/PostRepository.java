package com.example.postserver.postServer.post;

import com.example.postserver.postServer.comment.Comment;

import java.util.HashMap;

/**
 * Created by Julitt on 15.06.2017.
 */

public class PostRepository {

    HashMap<Long, Post> posts;
    static long id=0;

    public PostRepository(){
        posts = new HashMap<>();
        Post post1 = new Post(id++, "Tytul", "Tresc");
        Post post2 = new Post(id++, "Tytul 2", "Tresc posta 2");
        Comment comment = new Comment();
        comment.setContent("Przykładowa treść komentarza");
        post1.addComment(comment);
        posts.put(post1.getId(), post1);
        posts.put(post2.getId(), post2);
    }

    public Post addPost(Post post){
        post.setId(id++);
        return posts.put(post.getId(),post);
    }

}
