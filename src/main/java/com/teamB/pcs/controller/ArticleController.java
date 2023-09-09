package com.teamB.pcs.controller;

import com.teamB.pcs.dto.request.ArticleRequest;
import com.teamB.pcs.dto.response.ArticleListResponse;
import com.teamB.pcs.dto.response.ArticleResponse;
import com.teamB.pcs.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/articles")
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping("")
    public ArticleListResponse getAll(){
        return articleService.getAll();
    }

    @PostMapping("")
    public void create(@RequestBody ArticleRequest articleRequest){
        articleService.create(articleRequest);
    }

    @GetMapping("/{articleId}")
    public ArticleResponse get(@PathVariable Long articleId){
        return articleService.get(articleId);
    }

    @PutMapping("/{articleId}")
    public void update(@PathVariable Long articleId, @RequestBody ArticleRequest articleRequest){
        articleService.update(articleId, articleRequest);
    }

    @DeleteMapping("/{articleId}")
    public void delete(@PathVariable Long articleId){
        articleService.delete(articleId);
    }
}
