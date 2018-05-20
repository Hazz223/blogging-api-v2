package com.harry.winser.api.article.service.internal.converters;

import com.harry.winser.api.article.domain.internal.Article;
import com.harry.winser.api.article.web.ArticleDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ArticleToArticleDtoConverter implements Converter<Article, ArticleDto> {

    @Override
    public ArticleDto convert(Article source) {

        return new ArticleDto(source.getGuid(),
                source.getDate(),
                source.getType(),
                source.getTitle(),
                source.getData(),
                source.getCleanTitle());
    }
}
