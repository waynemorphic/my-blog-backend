package com.blog.blogpost.article;

import javax.persistence.*;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.*;
import com.blog.blogpost.writer.Writer;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Article {
    @Id
    @Column
    private int id;

    @Column
    @NotNull(message = "Title cannot be blank")
    @NotBlank(message = "Title cannot be blank")
    @Size(max = 250)
    private String title;

    @Column
    private @NonNull Date date;

    @Column
    @NotNull(message = "Body cannot be blank")
    @NotBlank(message = "Body cannot be blank")
    private String body;

    @Column
    @NotNull(message = "Category cannot be blank")
    @NotBlank(message = "Category cannot be blank")
    @Size(max = 30)
    private String category;

    @Column
    private String media;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "writer_id") // Many articles, one writer
    // @JsonIgnore
    private Writer writer;

    public Article(){
        super();
    }

    public Article(int id, String title, Date date, String body, String category, String media, Writer writer){
        this.id = id;
        this.title = title;
        this.date = date;
        this.body = body;
        this.category = category;
        this.media = media;
        this.writer = writer;
    }
}
