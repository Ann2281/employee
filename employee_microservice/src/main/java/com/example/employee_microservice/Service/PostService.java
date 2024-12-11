package com.example.employee_microservice.Service;

import com.example.employee_microservice.Models.Post;
import com.example.employee_microservice.Repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;
    public Post get(int postId, int empId){
        Post post = repository.findByEmpIdAndPostId(empId, postId).orElse(null);
        if(post == null){
            post = new Post();
            post.setAlert_message("Такой должности не существует!");
        }
        return post;
    }
    public Post create(Post post){
        if(post != null){
            repository.save(post);
            post.setAlert_message("Должность успешно добавлена!");
        }
        return post;
    }
    public Post update(Post post){
        if(post != null){
            repository.save(post);
            post.setAlert_message("Должность успешно редактирована!");
        }
        return post;
    }
    public String remove(int postId){
        repository.deleteById(String.valueOf(postId));
        return "Должность удалена успешноЙ";
    }
}