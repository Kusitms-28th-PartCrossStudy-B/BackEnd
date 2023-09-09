package com.teamB.pcs.dto.response;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class ArticleListResponse {
    private boolean isSuccess;

    private String message;

    private List<ArticleResponse> data;

    @Builder
    public ArticleListResponse(boolean isSuccess, String message, List<ArticleResponse> data) {
        this.isSuccess = isSuccess;
        this.message = message;
        this.data = data;
    }
}
