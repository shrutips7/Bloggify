package com.masai.app.blog_application.service;

import com.masai.app.blog_application.entity.Blog;
import com.masai.app.blog_application.entity.Comment;
import com.masai.app.blog_application.entity.User;
import com.masai.app.blog_application.repository.BlogRepository;
import com.masai.app.blog_application.repository.CommentRepository;
import com.masai.app.blog_application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    BlogRepository blogRepository;

    public List<Comment> getAllComments() {
        List<Comment> commentInfo=commentRepository.findAll();
        return commentInfo;
    }

    public Comment addComment(Comment comment) {
        Comment comment1=commentRepository.save(comment);
        return comment1;
    }

    public String updateComment(Comment comment) {
        Optional<Comment> comment1=commentRepository.findById(comment.getCommentId());
        if(comment1.isEmpty()){
            return "Repository Error";
        }
        comment1.get().setCommentContent(comment.getCommentContent());
        commentRepository.save(comment1.get());
        return "Successfully Updated";

    }

    public String deleteComment(int commentId) {
        Comment comment1=commentRepository.findById(commentId).get();
        try{
            commentRepository.delete(comment1);
            return "Successfully Deleted";
        }
        catch(Exception ex){
            return "Deletion Failed";
        }

    }

    @Transactional
    public List<Comment> getAllCommentsParticularCourse(int blogId) {
        Optional<Blog> blog1=blogRepository.findById(blogId);
        if(blog1.isEmpty())
            //System.out.println("No such blog");
            return null;
        else
            {
                List<Comment> comments=blogRepository.findById(blogId).get().getComments();
                return comments;
        }


    }
}
