package com.example.blog.demo.blog;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.*;

@RestController
public class BlogController {
    
  private final CurdRepository repository;

  BlogController(CurdRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/blogs")
  public List<Blog> viewBlogs() {
        return repository.findAll();
  }

  @PostMapping("/blogs")
  public Blog createBlog(@RequestBody Blog newBlog) {      
      return repository.save(newBlog);
  }

  @PutMapping("/blogs/{id}")
  public Blog updateBlog(@PathVariable Long id, @RequestBody Blog newBlog) {
    return repository.findById(id)
    .map(blog -> {
        blog.setContent(newBlog.getContent()); 
        return repository.save(blog); 
    })
    .orElseGet(() -> {
        newBlog.setId(id);
        return repository.save(newBlog);
    });
      
  }

  @DeleteMapping("/blogs/{id}")
  public void putMethodName(@PathVariable Long id) {
    repository.deleteById(id);
    
  }
  
  


}
