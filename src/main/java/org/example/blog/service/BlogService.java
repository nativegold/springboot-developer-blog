package org.example.blog.service;

import lombok.RequiredArgsConstructor;
import org.example.blog.domain.Article;
import org.example.blog.repository.BlogRepository;
import org.example.blog.dto.AddArticleRequest;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }
}
