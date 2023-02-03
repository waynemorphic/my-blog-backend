package com.blog.blogpost.writer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class WriterController {
    @Autowired
    private WriterService writerService;

    @Autowired
    private DTOMappingService dtoMappingService;

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
    @ResponseBody
    public List<WriterDTO> getAllBloggers(){
        /* Call getAllBloggers from the DTOMappingService
            then store the result in a list of WriterDTO             
        */
        
        return dtoMappingService.getAllBloggers();
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
