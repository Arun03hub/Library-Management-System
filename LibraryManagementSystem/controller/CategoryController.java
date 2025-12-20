package com.example.LibraryManagementSystem.controller;

import com.example.LibraryManagementSystem.entity.Book;
import com.example.LibraryManagementSystem.entity.Category;
import com.example.LibraryManagementSystem.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getAllBooks(){
        List<Category> categories=categoryService.getAllCategory();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getBook(@PathVariable int id){
        Category category=categoryService.getCategoryById(id);
        if(category==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(category);
    }

    @PostMapping
    public ResponseEntity<Category> saveBook(@RequestBody Category category){
        Category createdCategory=categoryService.saveOrUpdateCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateAuthor(@PathVariable int id, @RequestBody Category category){
        Category existingCategory=categoryService.getCategoryById(id);
        if(existingCategory==null){
            return ResponseEntity.notFound().build();
        }
        category.setId(id);
        categoryService.saveOrUpdateCategory(category);
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable int id){
        Category deleteCategory=categoryService.getCategoryById(id);
        if(deleteCategory==null){
            return ResponseEntity.notFound().build();
        }
        categoryService.deleteCategoryById(id);
        return ResponseEntity.noContent().build();
    }
}
