package com.blog.blogpost.writer;

import lombok.*;

@Getter @Setter
public class WriterDTO {
    private String name;
    private String email;
    private String password;
}

/*
 * DTO do not contain any business logic but mechanisms of serialization and deserialization
 * DTO's can store data from a single or multiple sources
 * They are used to reduce the number of expensive remote calls
 * Mappers are used to convert data between a DTO and any entity objects
 * They can minimize the amount of data that is shareable from a source. However,
 *  they can also be used to share complete data from the source.
 */