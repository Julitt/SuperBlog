package com.example.postserver.postServer.post;

import com.example.postserver.postServer.comment.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Julitt on 15.06.2017.
 */

@RestController
public class PostController {

    @Autowired
    private PostService service;

    @RequestMapping(method = RequestMethod.GET, value = "/posts")
    public List<Collection<Post>> getAllPost(){
        return service.getAllPosts();
    }

    // TODO: addPost, deletePost, editPost, addComment, editComment, getAllPosts

    @RequestMapping(method = RequestMethod.POST, value = "/posts")
    public String addPost(@RequestBody Post post){
        service.addPost(post);
        return "Post o tytule '"+post.getTitle()+"' dodany prawidłowo";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/posts/{id}")
    public Post getPostById(@PathVariable("id") Long id){
        return service.getPostById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/posts/{id}")
    public String editPost(@PathVariable("id") Long id, @RequestBody Post post){
       Boolean result = service.editPost(id, post);
        if(result){
            return "Post edytowany prawidłowo";
        }else {
            return "Błąd edycji posta";
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/posts/{id}")
    public String deletePost(@PathVariable("id") Long id){
        Boolean result = service.deletePostById(id);
        if(result){
            return "Post usunięty prawidłowo";
        }else {
            return "Błąd usuwania posta";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/posts/{id}/comments")
    public List<Collection<Comment>> getAllCommentsFromPost(@PathVariable("id") long postId){
        return service.getCommentsByPostId(postId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/posts/{id}")
    public String addComment(@PathVariable("id") long postId, @RequestBody Comment comment){
        Boolean result = service.addComment(postId, comment);
        if(result){
            return "Komentarz dodany prawidłowo";
        }else {
            return "Błąd dodawania komentarza";
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/posts/{id}/comments/{comId}")
    public String editComment(@PathVariable("id") long postId,@PathVariable("comId") long id, @RequestBody Comment comment){
        Boolean result = service.editComment(postId, id, comment);
        if(result){
            return "Komentarz edytowany prawidłowo";
        }else {
            return "Błąd edycji komentarza";
        }
    }

}
