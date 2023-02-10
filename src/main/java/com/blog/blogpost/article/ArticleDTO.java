package com.blog.blogpost.article;

import lombok.*;
import java.util.*;
import com.blog.blogpost.writer.Writer;

@Getter
@Setter
public class ArticleDTO {
    private int id;
    private String title;
    private Date date;
    private String body;
    private String category;
    private String media;
    private Writer writer; 
}
