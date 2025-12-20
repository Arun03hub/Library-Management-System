package com.example.LibraryManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;

    @ManyToMany//Many authors have many books, many books have many authors
    @JoinTable(name="books_authors",
               joinColumns ={@JoinColumn(name="book_id")},
                inverseJoinColumns = {@JoinColumn(name="author_id")})
    private List<Authors> authors;

    @ManyToMany
    @JoinTable(name="books_categories",
            joinColumns ={@JoinColumn(name="book_id")},
            inverseJoinColumns = {@JoinColumn(name="category_id")})
    private List<Category> categories;

    @ManyToMany
    @JoinTable(name="books_publishers",
            joinColumns ={@JoinColumn(name="book_id")},
            inverseJoinColumns = {@JoinColumn(name="publisher_id")})
    private List<Publisher>publishers;

}
