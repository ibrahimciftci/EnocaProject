package com.ibrahimciftci.enoca.model;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ibrahimciftci.enoca.dto.LibraryDTO;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "libraries")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String address;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL,})
    @JoinTable(name = "library_books", joinColumns = {@JoinColumn(name = "library_id")}, inverseJoinColumns = {@JoinColumn(name = "book_id")})
    private Set<Book> books = new HashSet<>();


    public void updateBooks(Set<Book> books){
        this.books.clear();
        this.books.addAll(books);
    }
    public static Library fromDTO(LibraryDTO dto){
        Library library = new Library();
        library.setAddress(library.getAddress());
        library.setBooks(dto.getBooks());
        library.setName(dto.getName());
        return library;

    }
}
