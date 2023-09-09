package com.teamB.pcs.controller;

import com.teamB.pcs.dto.request.ArticleRequest;
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
    public List<ArticleResponse> getAll(){
        return articleService.getAll();
    }

    @PostMapping("/{articleId}")
    public void create(@PathVariable Long articleId, @RequestBody ArticleRequest articleRequest){
        return articleService.create(articleId, articleRequest);
    }

    @GetMapping("/{articleId}")
    public ArticleResponse get(@PathVariable Long articleId){
        return articleService.get(articleId);
    }

    @PutMapping("/{articleId}")
    public void update(@PathVariable Long articleId, @RequestBody ArticleRequest articleRequest){
        return articleService.update(articleId, articleRequest);
    }

    @DeleteMapping("/{articleId}")
    public void delete(@PathVariable Long articleId){
        return articleService.delete(articleId);
    }
}
