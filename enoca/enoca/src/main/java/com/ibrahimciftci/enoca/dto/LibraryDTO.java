package com.ibrahimciftci.enoca.dto;

import com.ibrahimciftci.enoca.model.Book;
import com.ibrahimciftci.enoca.model.Library;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibraryDTO {

    private Long id;
    private String name;
    private String address;
    private Set<Book> books = new HashSet<>();

    public static LibraryDTO fromEntity(Library from){
        return new LibraryDTO(from.getId(),from.getName(),from.getAddress(),from.getBooks());
    }
}
