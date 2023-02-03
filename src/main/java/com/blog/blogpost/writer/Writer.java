package com.blog.blogpost.writer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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
    private @NonNull String name;    
    
    @Column
    private @NonNull String email;
    
    public Writer(int id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }


}
