package com.teamB.pcs.dto.response;

import com.teamB.pcs.domain.Article;
import com.teamB.pcs.domain.Tag;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Getter
public class ArticleResponse {
    private Long id;

    private String title;

    private String description;

    private String body;

    private List<Tag> tagList;

    private LocalDateTime createdAt;//반환할때 LocalDateTime으로 해도되나?

    private LocalDateTime updatedAt;

    public ArticleResponse(Article article){
        id=article.getId();
        title=article.getTitle();
        description=article.getDescription();
        body=article.getBody();
        tagList=article.getTags();
        createdAt=article.getCreatedAt();
        updatedAt=article.getUpdatedAt();
    }
}
