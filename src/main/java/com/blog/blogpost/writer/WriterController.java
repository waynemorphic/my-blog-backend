package com.blog.blogpost.writer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class WriterController {
    @Autowired
    private WriterService writerService;

    // Post
    @PostMapping(value="/blogger")
    public String postWriter(@RequestBody Writer writer) {
        //TODO: process POST request
        writerService.postWriter(writer);
        
        return "200: Posted Successfully";
    }

    // Get one
    @GetMapping(value="/blogger/{id}")
    public Optional<Writer> getBlogger(@PathVariable int id){
        return writerService.getBlogger(id);
    }

    // Get all
    @GetMapping(value="/blogger")
    public List<Writer> getBloggers(@RequestBody Writer writer){
        return writerService.getBloggers();
    }

    // Delete
    @DeleteMapping(value="/blogger/{id}")
    public String deleteBlogger(@PathVariable int id){
        writerService.deleteBlogger(id);
        return "200: Deleted Successfully";
    }

    // Put
    @PutMapping(value="/blogger/{id}")
    public String putBlogger(@RequestBody Writer writer, @PathVariable int id){
        writerService.putBlogger(id, writer);
        return "200: OK";
    }
    
}
