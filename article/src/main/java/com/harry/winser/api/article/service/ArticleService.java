package com.harry.winser.api.article.service;

import com.harry.winser.api.article.web.ArticleDto;

import java.util.Set;

public interface ArticleService {

    Set<ArticleDto> getAll();

    ArticleDto getById(String id);

}
