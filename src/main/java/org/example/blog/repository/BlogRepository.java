package org.example.blog.repository;

import org.example.blog.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// 데이터베이스 연결을 위한 레포지토리
@Repository
public interface BlogRepository extends JpaRepository<Article, Long> {
}
