package com.example.postserver.postServer.post;

import com.example.postserver.postServer.comment.Comment;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Julitt on 15.06.2017.
 */

@Service
public class PostService {


    private PostRepository repository = new PostRepository();


    public List<Collection<Post>> getAllPosts() {
        return Arrays.asList(repository.posts.values());
    }

    public Post getPostById(Long id) {
        return repository.posts.get(id);
    }

    public List<Collection<Comment>> getCommentsByPostId(long postId) {
        return Arrays.asList(repository.posts.get(postId).getComments().values());
    }

    public Post addPost(Post post) {
        return repository.addPost(post);
    }

    public boolean deletePostById(Long id) {
        if (repository.posts.containsKey(id)) {
            repository.posts.remove(id);
            return true;
        } else {
            return false;
        }
    }

    public boolean editPost(Long id, Post post) {
        if (repository.posts.containsKey(id)) {
            Post oldPost = repository.posts.get(id);
            if (post.getComments().size() == 0) {
                post.setComments(oldPost.getComments());
            }
            if (post.getTitle() == null) {
                post.setTitle(oldPost.getTitle());
            }
            if (post.getContent() == null) {
                post.setContent(oldPost.getContent());
            }
            repository.posts.replace(post.id, post);
            return true;
        } else {
            return false;
        }
    }

    public boolean editComment(long postId, long comId, Comment comment) {
        if (repository.posts.containsKey(postId) && repository.posts.get(postId).getComments().containsKey(comId)) {
            HashMap<Long, Comment> comments = repository.posts.get(postId).getComments();
            comment.setId(comId);
            comments.replace(comId, comment);
            return true;

        } else {
            return false;
        }
    }

    public boolean addComment(long postId, Comment comment) {
        if (repository.posts.containsKey(postId)) {
            repository.posts.get(postId).addComment(comment);
            return true;
        } else {
            return false;
        }
    }
}
