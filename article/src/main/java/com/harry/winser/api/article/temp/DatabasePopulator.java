package com.harry.winser.api.article.temp;

import com.harry.winser.api.article.domain.internal.ArticleDao;
import com.harry.winser.api.article.service.internal.converters.ArticleDtoToArticleConverter;
import com.harry.winser.api.article.web.ArticleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct; // Hadd to add to module path - watch out for this.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

@Component
public class DatabasePopulator {
    private final ArticleDao articleDao;
    private final ArticleDtoToArticleConverter converter;

    @Autowired
    public DatabasePopulator(ArticleDao articleDao, ArticleDtoToArticleConverter converter) {
        this.articleDao = articleDao;
        this.converter = converter;
    }

    public void populateDatabase() {

        RestTemplate template = new RestTemplate();

        ResponseEntity<ArticleDtoWrapper> response = template.getForEntity("http://api.harrywinser.com/article?size=1000", ArticleDtoWrapper.class);

        response.getBody().getContent().stream()
                .map(this.converter::convert)
                .forEach(this.articleDao::save);
    }
}
