package com.blog.blogpost.writer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.*;

import java.util.*;
import com.blog.blogpost.article.Article;

import lombok.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor

public class Writer {
    @Id
    @Column
    private int id;    
    
    @Column
    @NotNull(message = "Username cannot be blank")
    @NotBlank(message = "Username cannot be blank")
    private @NonNull String name;    
    
    @Column
    @Email(message = "Please enter a valid email address", regexp="^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,5}")
    @NotNull(message = "Email cannot be blank")
    @NotBlank(message = "Email cannot be blank")
    private @NonNull String email;

    @Column
    @NotNull(message = "Password cannot be blank")
    @NotBlank(message = "Password cannot be blank")
    @Size(min = 7, message = "Password should have more than seven characters")
    private @NonNull String password;

    @OneToMany(mappedBy = "writer", cascade = CascadeType.ALL)
    @JsonIgnore // ignores the recursive call to Article and its properties
    private List<Article> articles;

    public Writer(){
        super();
    }
    
    public Writer(int id, String name, String email, String password){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }


}
