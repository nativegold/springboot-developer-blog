package org.example.blog.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.blog.domain.Article;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class ArticleViewResponse {      // 응답에 사용할 게시글 DTO
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;

    public ArticleViewResponse(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.createdAt = article.getCreatedAt();
    }
}
