package com.ibrahimciftci.enoca.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.ibrahimciftci.enoca.dto.BookDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String writer;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy = "books")
    @JsonIgnore
    private Set<Library> libraries = new HashSet<>();

    public void updateLibraries(Set<Library> libraries) {
        this.libraries.clear();
        this.libraries.addAll(libraries);
    }

    public static Book fromDTO(BookDTO bookDTO){
         Book book= new Book();
         book.setLibraries(bookDTO.getLibraries());
         book.setName(bookDTO.getName());
         book.setWriter(bookDTO.getWriter());
         return book;
    }

}
