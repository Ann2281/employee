package com.example.employee_microservice.Controllers;

import com.example.employee_microservice.Models.Post;
import com.example.employee_microservice.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "employee/{empId}/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @RequestMapping(value = "/{postId}", method = RequestMethod.GET)
    public ResponseEntity<Post> get(@PathVariable("empId") int empId, @PathVariable("postId") int postId) {
        Post post = postService.get(empId, postId);
        return ResponseEntity.ok(post);
    }

    @PostMapping
    public ResponseEntity<Post> POST(@RequestBody Post request) {
        return ResponseEntity.ok(postService.create(request));
    }

    @PutMapping
    public ResponseEntity<Post> PUT(@RequestBody Post request) {
        return ResponseEntity.ok(postService.update(request));
    }

    @DeleteMapping(value= "/{postId}")
    public ResponseEntity<String> DELETE(@PathVariable("postId") int postId) {
        return ResponseEntity.ok(postService.remove(postId));
    }
}
