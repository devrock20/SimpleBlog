package com.example.blog.demo.blog;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.*;


@Entity
public class Blog {
  
  private @Id
  @GeneratedValue Long id;
  private String content;
  private String title;
  private List<String> comments;
  

  public String getTitle() {
    return title;
}

public void setTitle(String title) {
    this.title = title;
}

public List<String> getComments() {
    return comments;
}

public void setComments(List<String> comments) {
    this.comments = comments;
}

Blog() {}

  Blog(String content) {

    this.content = content;
  }



public Long getId() {
    return id;
}


public void setId(Long id) {
    this.id = id;
}


public String getContent() {
    return content;
}


public void setContent(String content) {
    this.content = content;
}

  
}
