package org.example.blog.controller;

import lombok.RequiredArgsConstructor;
import org.example.blog.domain.Article;
import org.example.blog.dto.ArticleListViewResponse;
import org.example.blog.dto.ArticleViewResponse;
import org.example.blog.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BlogViewController {   // 사용자 요청에 따른 뷰를 반환하기 위한 컨트롤러
    private final BlogService blogService;

    // 모든 게시글의 목록을 보여주는 View 반환
    @GetMapping("/articles")
    public String getArticles(Model model) {
        List<ArticleListViewResponse> articles = blogService.findAll()
                .stream().map(ArticleListViewResponse::new).toList();
        model.addAttribute("articles", articles);

        return "articleList";
}

    // 특정 ID 게시글 내용을 보여주는 View 반환
    @GetMapping("/articles/{id}")
    public String getArticles(@PathVariable Long id,  Model model) {
        Article article = blogService.findById(id);
        model.addAttribute("article", new ArticleViewResponse(article));

        return "article";
    }

    // 새 게시물 작성 또는 특정 ID 게시글 수정하는 뷰 반환
    @GetMapping("/new-article")
    public String newArticle(@RequestParam(required = false) Long id, Model model) {
        if(id == null) {
            model.addAttribute("article", new ArticleViewResponse());
        } else {
            Article article = blogService.findById(id);
            model.addAttribute("article", new ArticleViewResponse(article));
        }

        return "newArticle";
    }
}
