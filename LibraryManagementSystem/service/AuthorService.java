package com.example.LibraryManagementSystem.service;

import com.example.LibraryManagementSystem.entity.Authors;
import com.example.LibraryManagementSystem.repo.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepo authorRepo;

    public List<Authors> getAllAuthors(){
        return authorRepo.findAll();
    }

    public Authors getAuthorById(int id){
        return authorRepo.findById(id).orElse(null);
    }

    public Authors saveOrUpdateAuthor(Authors author){
        return authorRepo.save(author);
    }
    public void deleteAuthorById(int id){
        authorRepo.findById(id).orElse(null);
        authorRepo.deleteById(id);
    }
}
