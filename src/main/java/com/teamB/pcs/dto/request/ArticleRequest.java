package com.teamB.pcs.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ArticleRequest {
    private String title;

    private String description;

    private String body;
    
    //태그리스트추가
}
