package com.dimchev.spring_jdbc.repository;

import com.dimchev.spring_jdbc.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Integer> {
}
