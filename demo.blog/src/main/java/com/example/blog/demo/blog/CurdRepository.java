package com.example.blog.demo.blog;

import org.springframework.data.jpa.repository.JpaRepository;

interface CurdRepository extends JpaRepository<Blog, Long> {

    
}
