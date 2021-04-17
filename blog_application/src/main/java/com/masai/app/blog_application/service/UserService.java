package com.masai.app.blog_application.service;

import com.masai.app.blog_application.entity.Blog;
import com.masai.app.blog_application.entity.Comment;
import com.masai.app.blog_application.entity.User;
import com.masai.app.blog_application.repository.BlogRepository;
import com.masai.app.blog_application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BlogRepository blogRepository;

    public List<User> getAllUsers(){
        List<User> userInfo=userRepository.findAll();
        return userInfo;

    }

    public User addUser(User user) {
        User user1=userRepository.save(user);
        return user1;
    }

    public String updateStudent(User user) {
        Optional<User> user1=userRepository.findById(user.getUserId());
        if(user1.isEmpty()){
            return "Repository Error";
        }
        user1.get().setUserName(user.getUserName());
        user1.get().setEmailId(user.getEmailId());

        userRepository.save(user1.get());

        return "Info updated";

    }
    public String deleteUser(int userId) {
        User user1 = userRepository.findById(userId).get();
        try
        {
            userRepository.delete(user1);
            return "Successfully Deleted";
        }
        catch(Exception e){
            return "Delete Failed";

        }
    }

    public List<Blog> getAllBlogsOfAUser(Integer userId) {
        Optional<User> user1=userRepository.findById(userId);
        if(user1.isEmpty())
            //System.out.println("No such blog");
            return null;
        else
        {
            List<Blog> blogs=user1.get().getBlogs();
            return blogs;
        }

    }
}
