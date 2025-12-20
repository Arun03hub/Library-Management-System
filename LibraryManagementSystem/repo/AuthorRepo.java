package com.example.LibraryManagementSystem.repo;

import com.example.LibraryManagementSystem.entity.Authors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Authors,Integer> {

}
