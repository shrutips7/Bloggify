package com.masai.app.blog_application.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    Integer userId;
    String userName;
    String emailId;
    @JsonManagedReference
    @OneToMany(mappedBy = "commentCreator",fetch = FetchType.LAZY) // One blog can have many comments
    List<Comment> comments=new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "blogCreator",fetch = FetchType.LAZY)
    List<Blog> blogs=new ArrayList<>();

    public void addBlog(Blog blog){
        this.blogs.add(blog);
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void removeBlog(Blog blog){
        this.blogs.remove(blog);
    }

    public void addComment(Comment comment){
        this.comments.add(comment);
    }

    public void removeComment(Comment comment){
        this.comments.remove(comment);
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmailId() {
        return emailId;
    }
}
