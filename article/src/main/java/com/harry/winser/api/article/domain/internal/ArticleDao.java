package com.harry.winser.api.article.domain.internal;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface ArticleDao extends MongoRepository<Article, String> {

    Optional<Article> findByGuid(String guid);
}
