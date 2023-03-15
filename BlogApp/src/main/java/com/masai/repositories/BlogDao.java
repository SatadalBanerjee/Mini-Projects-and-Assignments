package com.masai.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Blog;

@Repository
public interface BlogDao extends JpaRepository<Blog, Integer>{

	 public List<Blog> findByCategory(String category);
}
