package com.dimchev.spring_jdbc;

import com.dimchev.spring_jdbc.model.Author;
import com.dimchev.spring_jdbc.model.Comment;
import com.dimchev.spring_jdbc.model.Post;
import com.dimchev.spring_jdbc.repository.AuthorRepository;
import com.dimchev.spring_jdbc.repository.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

import java.math.BigInteger;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcApplication.class, args);
	}

    @Bean
    CommandLineRunner commandLineRunner(PostRepository postRepository, AuthorRepository authorRepository){
       return args -> {
           var dimo = new Author(null,"Dimo","Dimchev","","dimchev");
           var author = authorRepository.save(dimo);

           AggregateReference<Author,Integer> referenceDimo=AggregateReference.to(author.id());
           var post = new Post("First Post","First Post Content",referenceDimo);
           post.addComment(new Comment("Dimo","First Comment"));
           postRepository.save(post);
       };
    }
}
