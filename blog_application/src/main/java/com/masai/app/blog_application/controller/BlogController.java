package com.masai.app.blog_application.controller;

import com.masai.app.blog_application.entity.Blog;
import com.masai.app.blog_application.entity.Comment;
import com.masai.app.blog_application.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping("/blogs")
    public List<Blog> getAllBlogs(){
        return blogService.getAllBlogs();
    }

    @PostMapping("/blog")
    public Blog addBlog(@RequestBody Blog blog){
        Blog blog1=blogService.addBlog(blog);
        return blog1;
    }

    @PutMapping("/blog")
    public String updateBlog(@RequestBody Blog blog){
        return blogService.updateBlog(blog);
    }

    @DeleteMapping("/blog/{id}")
    public String deleteBlog(@PathVariable("id") int blogId){
        boolean flag = blogService.deleteBlog(blogId);
        if(flag) return "Entry Deleted";
        else return "Fail to Delete";
    }

    @GetMapping("/blog/{id}/comments")
    public List<Comment> getCommentsOfABlog(@PathVariable("id") int blogId){
        return blogService.getCommentsOfABlog(blogId);
    }

}
