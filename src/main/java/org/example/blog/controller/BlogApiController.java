package org.example.blog.controller;

import lombok.RequiredArgsConstructor;
import org.example.blog.domain.Article;
import org.example.blog.dto.AddArticleRequest;
import org.example.blog.dto.ArticleResponse;
import org.example.blog.dto.UpdateArticleRequest;
import org.example.blog.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BlogApiController {    // 게시물 RESTful API
    private final BlogService blogService;  // 서비스

    // 새로운 게시글 추가 API
    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) {
        Article savedArticle = blogService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedArticle);
    }

    // 모든 게시글 찾기 API
    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles() {
        List<ArticleResponse> articles = blogService.findAll()
                .stream()
                .map(ArticleResponse::new)
                .toList();

        return ResponseEntity.ok().body(articles);
    }

    // 게시글 찾기 API
    @GetMapping("/api/articles/{id}")
    public ResponseEntity<ArticleResponse> findArticle(@PathVariable long id) {
        Article article = blogService.findById(id);

        return ResponseEntity.ok().body(new ArticleResponse(article));
    }

    // 게시글 삭제 API
    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable long id) {
        blogService.delete(id);

        return ResponseEntity.ok().build();
    }

    // 게시글 업데이트 API
    @PutMapping("/api/articles/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable long id,
                                                 @RequestBody UpdateArticleRequest request) {
        Article updateArticle = blogService.update(id, request);

        return ResponseEntity.ok().body(updateArticle);
    }
}
