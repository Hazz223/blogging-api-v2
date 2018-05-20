package com.harry.winser.api.article.web;

import com.harry.winser.api.article.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class ArticleController {

    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/articles")
    public Set<ArticleDto> getAllArticles(){

        return this.articleService.getAll();
    }

    @GetMapping("/articles/{id}")
    public ArticleDto getById(@PathVariable("id") String id){

        return this.articleService.getById(id);
    }
}
