package com.blog.blogpost.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.*;

@Service
public class ArticleDTOMappingService {
    @Autowired
    private ArticleRepository articleRepository;

    // Return a list of articles from DTO
    public List<ArticleDTO> getAllArticles(){
        return ((List<Article>) articleRepository
            .findAll())
            .stream()
            .map(this::DTOConverter)
                .collect(Collectors.toList());
    }

    private ArticleDTO DTOConverter(Article article){
        ArticleDTO articleDTO = new ArticleDTO();

        articleDTO.setId(article.getId());
        articleDTO.setWriter(article.getWriter());
        articleDTO.setDate(article.getDate());
        articleDTO.setTitle(article.getTitle());        
        articleDTO.setCategory(article.getCategory());
        articleDTO.setMedia(article.getMedia());
        articleDTO.setBody(article.getBody());

        return articleDTO;
    }
}
