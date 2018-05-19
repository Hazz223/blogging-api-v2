package com.harry.winser.api.article.service.internal;

import com.harry.winser.api.article.service.ArticleService;
import com.harry.winser.api.article.web.ArticleDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Set;
import java.util.UUID;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Override
    public Set<ArticleDto> getAll() {

        ArticleDto article = new ArticleDto(UUID.randomUUID().toString(), LocalDateTime.now(), "blog", "Some Title", "This is the data", "some-title");

        return Collections.singleton(article);
    }
}
