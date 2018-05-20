package com.harry.winser.api.article.service.internal.converters;

import com.harry.winser.api.article.web.ArticleDto;
import com.harry.winser.api.article.domain.internal.Article;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ArticleDtoToArticleConverter implements Converter<ArticleDto, Article> {

    @Override
    public Article convert(ArticleDto source) {

        return Article.builder()
                .withGuid(source.getId())
                .withCleanTitle(source.getCleanTitle())
                .withData(source.getData())
                .withDate(source.getDate())
                .withTitle(source.getTitle())
                .withType(source.getType())
                .build();
    }
}
