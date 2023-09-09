package com.teamB.pcs.service;

import com.teamB.pcs.domain.Article;
import com.teamB.pcs.dto.request.ArticleRequest;
import com.teamB.pcs.dto.response.ArticleListResponse;
import com.teamB.pcs.dto.response.ArticleResponse;
import com.teamB.pcs.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleListResponse getAll() {
        List<ArticleResponse> articleResponses = articleRepository.findAll().stream()
                .map(ArticleResponse::new)
                .collect(Collectors.toList());
        return ArticleListResponse.builder()
                .isSuccess(true)
                .message("게시글 목록 조회에 성공하였습니다.")
                .data(articleResponses)
                .build();
    }

    public ArticleResponse get(Long articleId) {
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));
        return new ArticleResponse(article);
    }

    @Transactional
    public void update(Long articleId, ArticleRequest articleRequest) {
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));
        article.update(articleRequest.getTitle(), articleRequest.getDescription(), articleRequest.getBody());
    }

    public void delete(Long articleId) {
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));
        articleRepository.delete(article);
    }

    public void create(ArticleRequest articleRequest) {
        Article article = Article.builder()
                .title(articleRequest.getTitle())
                .description(articleRequest.getDescription())
                .body(articleRequest.getBody())
                .build();
        articleRepository.save(article);
    }
}
