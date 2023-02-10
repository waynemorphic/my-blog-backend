package com.blog.blogpost.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;
    
    // Post impl
    public void postArticle(Article article){
        articleRepository.save(article);
    }

    // Get one impl
    public Optional<Article> getArticle(int id){
        return articleRepository.findById(id);
    }

    // Get all impl
    public List<Article> getArticles(){
        List<Article> articles = new ArrayList<>();
        articleRepository.findAll().forEach(articles::add);
        return articles;
    }

    // Delete impl
    public void deleteArticle(int id){
        articleRepository.deleteById(id);
    }

    // Put impl
    public void putArticle (int id, Article article){
        articleRepository.save(article);
    }
}
