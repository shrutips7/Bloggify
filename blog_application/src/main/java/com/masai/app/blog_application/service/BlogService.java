package com.masai.app.blog_application.service;

import com.masai.app.blog_application.entity.Blog;
import com.masai.app.blog_application.entity.Comment;
import com.masai.app.blog_application.repository.BlogRepository;
import com.masai.app.blog_application.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository;

    @Autowired
    CommentRepository commentRepository;


    public List<Blog> getAllBlogs() {
       return blogRepository.findAll();
    }

    public Blog addBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    public String updateBlog(Blog blog) {
        Optional<Blog> blog1=blogRepository.findById(blog.getBlogId());
        if(blog1.isEmpty()){
            return "Repository Error";
        }
        else{
            blog1.get().setBlogContent(blog.getBlogContent());
            blog1.get().setBlogTitle(blog.getBlogTitle());
            blogRepository.save(blog1.get());
            return "Info updated";
        }
    }

    public boolean deleteBlog(int blogId) {
        Blog blog=blogRepository.findById(blogId).get();

        try{
            blogRepository.delete(blog);
            return true;
        }
        catch (Exception ex){
            return false;
        }
    }

    @Transactional
    public void addCommentForBlog(int blogId, List<Comment> comments) {
        Blog blog = blogRepository.findById(blogId).get();
//      log.info("course.getReviews() --> {}",course.getReviewList());
        for(Comment comment : comments){
            blog.addComment(comment);
            comment.setBlog(blog);
            commentRepository.save(comment);
        }

    }

    public List<Comment> getCommentsOfABlog(int blogId) {
        List<Comment> comments=blogRepository.findById(blogId).get().getComments();
        return comments;
    }
}
