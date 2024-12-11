package com.example.employee_microservice.Repositories;

import com.example.employee_microservice.Models.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PostRepository extends CrudRepository<Post, String> {
    public Optional<Post> findByEmpIdAndPostId(int empId, int postId);
}
