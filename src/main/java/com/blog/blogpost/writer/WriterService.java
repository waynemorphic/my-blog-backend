package com.blog.blogpost.writer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class WriterService {
    @Autowired
    private WriterRepository writerRepository;

    // Post implementation
    public void postWriter(Writer writer){
        writerRepository.save(writer);
        
    }

    // Get one
    public Optional<Writer> getBlogger(int id){
        return writerRepository.findById(id);
    }

    // Get all
    public List<Writer> getBloggers(){
        List<Writer> writers = new ArrayList<>();
        writerRepository.findAll().forEach(writers::add);                
        return writers;
    }

    // Delete
    public void deleteBlogger(int id){
        writerRepository.deleteById(id);        
    }

    // Put implementation
    public String putBlogger(int id, Writer writer){
        writerRepository.save(writer);
        return "";
    }
}
