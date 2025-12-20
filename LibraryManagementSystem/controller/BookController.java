package com.example.LibraryManagementSystem.controller;

import com.example.LibraryManagementSystem.entity.Authors;
import com.example.LibraryManagementSystem.entity.Book;
import com.example.LibraryManagementSystem.entity.Category;
import com.example.LibraryManagementSystem.entity.Publisher;
import com.example.LibraryManagementSystem.service.AuthorService;
import com.example.LibraryManagementSystem.service.BookService;
import com.example.LibraryManagementSystem.service.CategoryService;
import com.example.LibraryManagementSystem.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private PublisherService publisherService;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> books=bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable int id){
        Book book=bookService.getBookById(id);
        if(book==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);
    }

    @PostMapping
    public ResponseEntity<Book> saveBook(@RequestBody Book book){
        List<Authors> authors=new ArrayList<Authors>();
        for(Authors authors1 : book.getAuthors()){
            Authors foundAuthor =authorService.getAuthorById((authors1.getId()));
            if(foundAuthor==null){
                return ResponseEntity.notFound().build();
            }
            authors.add(foundAuthor);
        }
        book.setAuthors(authors);

        List<Category> categories=new ArrayList<Category>();
        for(Category category : book.getCategories()){
            Category foundCategory =categoryService.getCategoryById((category.getId()));
            if(foundCategory==null){
                return ResponseEntity.notFound().build();
            }
            categories.add(foundCategory);
        }
        book.setCategories(categories);

        List<Publisher> publishers=new ArrayList<Publisher>();
        for(Publisher publisher : book.getPublishers()){
            Publisher foundPublisher =publisherService.getPublisherById((publisher.getId()));
            if(foundPublisher==null){
                return ResponseEntity.notFound().build();
            }
            publishers.add(foundPublisher);
        }
        book.setPublishers(publishers);

        Book createdBook=bookService.saveOrUpdateBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateAuthor(@PathVariable int id, @RequestBody Book book){
        Book existingBook=bookService.getBookById(id);
        if(existingBook==null){
            return ResponseEntity.notFound().build();
        }

        List<Authors> authors=new ArrayList<Authors>();
        for(Authors authors1 : book.getAuthors()){
            Authors foundAuthor =authorService.getAuthorById((authors1.getId()));
            if(foundAuthor==null){
                return ResponseEntity.notFound().build();
            }
            authors.add(foundAuthor);
        }
        book.setAuthors(authors);

        List<Category> categories=new ArrayList<Category>();
        for(Category category : book.getCategories()){
            Category foundCategory =categoryService.getCategoryById((category.getId()));
            if(foundCategory==null){
                return ResponseEntity.notFound().build();
            }
            categories.add(foundCategory);
        }
        book.setCategories(categories);

        List<Publisher> publishers=new ArrayList<Publisher>();
        for(Publisher publisher : book.getPublishers()){
            Publisher foundPublisher =publisherService.getPublisherById((publisher.getId()));
            if(foundPublisher==null){
                return ResponseEntity.notFound().build();
            }
            publishers.add(foundPublisher);
        }
        book.setPublishers(publishers);

        book.setId(id);
        bookService.saveOrUpdateBook(book);
        return ResponseEntity.ok(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable int id){
        Book book=bookService.getBookById(id);
        if(book==null){
            return ResponseEntity.notFound().build();
        }
        bookService.deleteBookById(id);
        return ResponseEntity.noContent().build();
    }
}
