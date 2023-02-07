package com.blog.blogpost.writer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;

import javax.validation.Valid;

@RestController
public class WriterController {
    @Autowired
    private WriterService writerService;

    @Autowired
    private DTOMappingService dtoMappingService;

    // Post
    @PostMapping(value="/blogger")
    public ResponseEntity<String> postWriter(@Valid @RequestBody Writer writer) {
        //TODO: process POST request
        writerService.postWriter(writer);        
        return new ResponseEntity<>("Posted Successfully", HttpStatus.CREATED);
    }

    // Get one
    @GetMapping(value="/blogger/{id}")
    public Optional<Writer> getBlogger(@PathVariable int id){
        return writerService.getBlogger(id);
    }

    // Get all
    @GetMapping(value="/blogger")
    @ResponseBody
    public List<WriterDTO> getAllBloggers(){
        /* Call getAllBloggers from the DTOMappingService
            then store the result in a list of WriterDTO             
        */
        
        return dtoMappingService.getAllBloggers();
    }

    // Delete
    @DeleteMapping(value="/blogger/{id}")
    public ResponseEntity<String> deleteBlogger(@PathVariable int id){
        writerService.deleteBlogger(id);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }

    // Put
    @PutMapping(value="/blogger/{id}")
    public ResponseEntity<Writer> putBlogger(@Valid @RequestBody Writer writer, @PathVariable int id){
        writerService.putBlogger(id, writer);
        return new ResponseEntity<>(writer, HttpStatus.ACCEPTED);
    }
    
}
