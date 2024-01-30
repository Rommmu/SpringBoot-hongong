package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleDto;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("articles")
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("create")
    public String createArticle(ArticleDto articleDto) {
        System.out.println(articleDto.toString());
        // 1. DTO를 엔터티로 변환
        Article article = articleDto.toEntity();
        System.out.println(article.toString());

        // 2. 리포지토리로 엔터티를 DB에 저장
        Article articleSaved = articleRepository.save(article);
        System.out.println(articleSaved.toString());
        return "articles/new";
    }
}
