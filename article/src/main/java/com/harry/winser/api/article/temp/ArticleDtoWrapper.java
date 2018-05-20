package com.harry.winser.api.article.temp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.harry.winser.api.article.web.ArticleDto;

import java.util.Objects;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ArticleDtoWrapper {

    private Set<ArticleDto> content;

    public Set<ArticleDto> getContent() {
        return content;
    }

    public void setContent(Set<ArticleDto> content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleDtoWrapper that = (ArticleDtoWrapper) o;
        return Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {

        return Objects.hash(content);
    }
}
