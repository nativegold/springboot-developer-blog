package org.example.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.blog.domain.Article;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddArticleRequest {    // 게시글 추가를 위한 게시글 목록 DTO
    private String title;
    private String content;

    // 해당 객체로 엔티티 생성
    public Article toEntity() {
        return Article.builder().title(title).content(content).build();
    }
}
