package com.dimchev.spring_jdbc.repository;

import com.dimchev.spring_jdbc.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post,Integer> {
}
