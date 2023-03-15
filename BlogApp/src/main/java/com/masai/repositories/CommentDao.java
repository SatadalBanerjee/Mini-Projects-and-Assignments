package com.masai.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Comment;

@Repository
public interface CommentDao extends JpaRepository<Comment, Integer>{

}
