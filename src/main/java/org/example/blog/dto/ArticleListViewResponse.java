package org.example.blog.dto;

import lombok.Getter;
import org.example.blog.domain.Article;

@Getter
public class ArticleListViewResponse {  // 응답을 위한 게시글 목록 DTO
    private final Long id;
    private final String title;
    private final String content;

    public ArticleListViewResponse(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
