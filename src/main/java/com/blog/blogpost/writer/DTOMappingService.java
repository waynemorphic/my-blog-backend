package com.blog.blogpost.writer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DTOMappingService {
    @Autowired
    private WriterRepository writerRepository;

    // Method to return a list of WriterDTO
    public List<WriterDTO> getAllBloggers(){
        return ((List<Writer>) writerRepository
            .findAll())
            .stream()
            .map(this::DTOConverter)
                .collect(Collectors.toList());
    }

    // DTO converter that returns WriterDTO
    private WriterDTO DTOConverter(Writer writer){
        
        // Instance of WriterDTO class
        WriterDTO writerDTO = new WriterDTO();

        // set name and email in DTO from the writer instance
        writerDTO.setId(writer.getId());
        writerDTO.setName(writer.getName());
        writerDTO.setEmail(writer.getEmail());

        return writerDTO;

    }
}
