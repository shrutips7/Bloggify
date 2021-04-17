package com.masai.app.blog_application.controller;

import com.masai.app.blog_application.entity.Comment;
import com.masai.app.blog_application.entity.User;
import com.masai.app.blog_application.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class CommentController {
    @Autowired
    CommentService commentService;

    @GetMapping("/comments")
    public List<Comment> getAllComments() {
        return commentService.getAllComments();
    }

    @PostMapping("/comment")
    public Comment addComment(@RequestBody Comment comment) {
        return commentService.addComment(comment);
    }

    @GetMapping("/comments/{id}")
    public List<Comment> getAllCommentsParticularCourse(@PathVariable("id") int blogId){
         return commentService.getAllCommentsParticularCourse(blogId);
    }


    @PutMapping("/comment")
    public String updateComment(@RequestBody Comment comment){
        return commentService.updateComment(comment);
    }

    @DeleteMapping("/comment/{id}")
    public String deleteComment(@PathVariable("id") int commentId){
        return commentService.deleteComment(commentId);
    }

}
