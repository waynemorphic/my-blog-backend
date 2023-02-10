package com.blog.blogpost.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import javax.validation.*;

import java.util.*;

@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleDTOMappingService dtoMappingService;

    // Post
    @PostMapping(value = "/article")
    public ResponseEntity<String> postArticle(@Valid @RequestBody Article article){
        articleService.postArticle(article);
        return new ResponseEntity<>("Article Posted Successfully", HttpStatus.CREATED);
    }
    
    // Get all
    @GetMapping(value = "/article")
    @ResponseBody
    public List<ArticleDTO> getArticles(){
        return dtoMappingService.getAllArticles();
    }

    // Get one
    @GetMapping(value = "/article/{id}")
    public Optional<Article> getArticle(@PathVariable int id){
        return articleService.getArticle(id);
    }

    // Put
    @PutMapping(value = "/article/{id}")
    public ResponseEntity<Article> putArticle(@Valid @RequestBody Article article){
        articleService.putArticle(0, article);
        return new ResponseEntity<>(article, HttpStatus.ACCEPTED);
    }
    
    // Delete
    @DeleteMapping(value = "article/{id}")
    public ResponseEntity<String> deleteArticle(@PathVariable int id){
        articleService.deleteArticle(id);
        return new ResponseEntity<>("Article Deleted Successfully", HttpStatus.GONE);
    }


}
