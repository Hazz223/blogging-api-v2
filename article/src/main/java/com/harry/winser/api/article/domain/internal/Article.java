package com.harry.winser.api.article.domain.internal;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.Objects;

public class Article {


    @Id
    private String id;
    private String guid;
    private LocalDateTime date;
    private String type;
    private String title;
    private String data;
    private String cleanTitle;

    public Article(String id,
                   String guid,
                   LocalDateTime date,
                   String type,
                   String title,
                   String data,
                   String cleanTitle) {

        this.id = id;
        this.guid = guid;
        this.date = date;
        this.type = type;
        this.title = title;
        this.data = data;
        this.cleanTitle = cleanTitle;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCleanTitle() {
        return cleanTitle;
    }

    public void setCleanTitle(String cleanTitle) {
        this.cleanTitle = cleanTitle;
    }

    public static ArticleBuilder builder(){
        return new ArticleBuilder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(id, article.id) &&
                Objects.equals(guid, article.guid) &&
                Objects.equals(date, article.date) &&
                Objects.equals(type, article.type) &&
                Objects.equals(title, article.title) &&
                Objects.equals(data, article.data) &&
                Objects.equals(cleanTitle, article.cleanTitle);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, guid, date, type, title, data, cleanTitle);
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", guid='" + guid + '\'' +
                ", date=" + date +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", data='" + data + '\'' +
                ", cleanTitle='" + cleanTitle + '\'' +
                '}';
    }

    public static final class ArticleBuilder {
        private String id;
        private String guid;
        private LocalDateTime date;
        private String type;
        private String title;
        private String data;
        private String cleanTitle;

        private ArticleBuilder() {
        }

        public ArticleBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public ArticleBuilder withGuid(String guid) {
            this.guid = guid;
            return this;
        }

        public ArticleBuilder withDate(LocalDateTime date) {
            this.date = date;
            return this;
        }

        public ArticleBuilder withType(String type) {
            this.type = type;
            return this;
        }

        public ArticleBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public ArticleBuilder withData(String data) {
            this.data = data;
            return this;
        }

        public ArticleBuilder withCleanTitle(String cleanTitle) {
            this.cleanTitle = cleanTitle;
            return this;
        }

        public Article build() {
            return new Article(id, guid, date, type, title, data, cleanTitle);
        }
    }
}
