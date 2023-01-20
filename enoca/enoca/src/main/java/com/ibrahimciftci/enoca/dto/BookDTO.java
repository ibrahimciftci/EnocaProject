package com.ibrahimciftci.enoca.dto;

import com.ibrahimciftci.enoca.model.Book;
import com.ibrahimciftci.enoca.model.Library;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private Long id;
    private String name;
    private String writer;
    private Set<Library> libraries = new HashSet<>();

    public static BookDTO fromEntity(Book book){
        return new BookDTO(book.getId(),book.getName(),book.getWriter(),book.getLibraries());

    }
}
