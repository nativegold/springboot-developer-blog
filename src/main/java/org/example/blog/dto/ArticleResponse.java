package org.example.blog.dto;

import lombok.Getter;
import org.example.blog.domain.Article;

@Getter
public class ArticleResponse {  // 응답을 위한 게시글 데이터 DTO
    private final String title;
    private final String content;

    public ArticleResponse(Article article) {
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
