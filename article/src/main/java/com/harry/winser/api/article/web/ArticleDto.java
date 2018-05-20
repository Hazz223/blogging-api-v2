package com.harry.winser.api.article.web;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ArticleDto {

    private final String id;
    @JsonDeserialize(using = DateDeseraliser.class)
    private final LocalDateTime date;
    private final String type;
    private final String title;
    private final String data;
    @JsonProperty("clean_title")
    private final String cleanTitle;

    @JsonCreator
    public ArticleDto(@JsonProperty("id") String id,
                      @JsonProperty("date") LocalDateTime date,
                      @JsonProperty("type") String type,
                      @JsonProperty("title") String title,
                      @JsonProperty("data") String data,
                      @JsonProperty("clean_title") String cleanTitle) {
        this.id = id;
        this.date = date;
        this.type = type;
        this.title = title;
        this.data = data;
        this.cleanTitle = cleanTitle;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getData() {
        return data;
    }

    public String getCleanTitle() {
        return cleanTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleDto that = (ArticleDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(date, that.date) &&
                Objects.equals(type, that.type) &&
                Objects.equals(title, that.title) &&
                Objects.equals(data, that.data) &&
                Objects.equals(cleanTitle, that.cleanTitle);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, date, type, title, data, cleanTitle);
    }

    @Override
    public String toString() {
        return "ArticleDto{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", data='" + data + '\'' +
                ", cleanTitle='" + cleanTitle + '\'' +
                '}';
    }
}
