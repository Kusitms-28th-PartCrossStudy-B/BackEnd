package com.teamB.pcs.service;

import com.teamB.pcs.dto.response.ArticleResponse;
import com.teamB.pcs.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public List<ArticleResponse> getAll() {
        return articleRepository.findAll().stream()
                .map()
    }
}
