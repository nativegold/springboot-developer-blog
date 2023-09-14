package org.example.blog.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Article {      // 데이터베이스와 연결을 위한 엔티티
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    // 게시글 제목
    @Column(name = "title", nullable = false)
    private String title;

    // 게시글 내용
    @Column(name = "content", nullable = false)
    private String content;

    // 게시글 생성 날짜
    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // 게시글 수정 날짜
    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updated_at;

    @Builder
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
