package org.example.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateArticleRequest {     // 게시글 수정에 사용하는 DTO
    private String title;
    private String content;
}
