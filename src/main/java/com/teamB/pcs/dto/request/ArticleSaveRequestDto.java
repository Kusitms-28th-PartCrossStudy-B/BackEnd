package com.teamB.pcs.dto.request;

import com.teamB.pcs.domain.Article;
import com.teamB.pcs.domain.Tag;

import java.util.List;

public record ArticleSaveRequestDto(String title, String description, String body, List<String> tags) {

    public Article toEntity(String title, String description, String body, List<Tag> tags) {
        return Article.builder()
                .title(title)
                .description(description)
                .body(body)
                .tags(tags)
                .build();
    }
}
