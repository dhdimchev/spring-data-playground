package com.dimchev.spring_jdbc.controller;

import com.dimchev.spring_jdbc.model.Post;
import com.dimchev.spring_jdbc.model.dto.PostDetails;
import com.dimchev.spring_jdbc.repository.AuthorRepository;
import com.dimchev.spring_jdbc.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostContorller {

    private final PostRepository postRepository;
    private final AuthorRepository authorRepository;

    public PostContorller(PostRepository postRepository, AuthorRepository authorRepository) {
        this.postRepository = postRepository;
        this.authorRepository = authorRepository;
    }


    @GetMapping(value = "/posts")
    public Iterable<Post> getAll(){
        return postRepository.findAll();
    }

    @GetMapping("/{id}")
    public Post getById(@PathVariable Integer id){
        return postRepository.findById(id).orElse(null);
    }

    @GetMapping("/{id}/details")
    public PostDetails getPostDetails(@PathVariable Integer id){
        var post = postRepository.findById(id).orElse(null);
        if(post == null){
            return null;
        }

        var author = authorRepository.findById(post.getAuthor().getId()).orElse(null);
        if(author == null){
            return null;
        }
        return new PostDetails(author,post);
    }

}
