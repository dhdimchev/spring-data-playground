package com.dimchev.spring_jdbc.model.dto;

import com.dimchev.spring_jdbc.model.Author;
import com.dimchev.spring_jdbc.model.Post;

public record PostDetails(Author author, Post post) {
}
