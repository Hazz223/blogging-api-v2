package com.harry.winser.api.article.service.internal;

import com.harry.winser.api.article.domain.internal.ArticleDao;
import com.harry.winser.api.article.service.ArticleService;
import com.harry.winser.api.article.service.exceptions.ArticleNotFoundException;
import com.harry.winser.api.article.web.ArticleDto;
import com.harry.winser.api.article.service.internal.converters.ArticleToArticleDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements ArticleService {

    // todo: finish conversion / implementation of endpoints
    // Start adding security to enable uploads etc.
    // Start building blogging upload section.
    // Use Spring security + facebook, if possible

    private final ArticleDao articleDao;
    private final ArticleToArticleDtoConverter articleToArticleDtoConverter;

    @Autowired
    public ArticleServiceImpl(ArticleDao articleDao, ArticleToArticleDtoConverter articleToArticleDtoConverter) {
        this.articleDao = articleDao;
        this.articleToArticleDtoConverter = articleToArticleDtoConverter;
    }
    @Override
    public Set<ArticleDto> getAll() {

        return this.articleDao.findAll().stream()
                .map(this.articleToArticleDtoConverter::convert)
                .collect(Collectors.toSet());
    }

    @Override
    public ArticleDto getById(String id) {
        return Optional.ofNullable(id)
                .map(this.articleDao::findByGuid)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(this.articleToArticleDtoConverter::convert)
                .orElseThrow(() -> new ArticleNotFoundException("Could not find article for given ID"));
    }
}
