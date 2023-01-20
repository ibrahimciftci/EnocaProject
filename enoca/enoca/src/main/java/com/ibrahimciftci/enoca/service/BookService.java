package com.ibrahimciftci.enoca.service;

import java.util.ArrayList;
import java.util.List;

import com.ibrahimciftci.enoca.dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibrahimciftci.enoca.model.Book;
import com.ibrahimciftci.enoca.repository.IBookRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {

    @Autowired
    private IBookRepository bookRepository;

    public List<BookDTO> bookList() {
        return new ArrayList<>(bookRepository.findAll().stream().map(BookDTO::fromEntity).toList());
    }

    public BookDTO saveBook(BookDTO dto) {
        Book book = bookRepository.save(Book.fromDTO(dto));
        return BookDTO.fromEntity(book);
    }

    public boolean deleteById(Long id) {
        Book temp = findById(id);
        if (temp == null) {
            throw new RuntimeException("Book is not found");
        }
        bookRepository.deleteById(id);
        return true;
    }

    public BookDTO update(Long id, BookDTO dto) {
        Book book = findById(id);
        book.setName(dto.getName());
        book.setWriter(dto.getWriter());
        book.updateLibraries(dto.getLibraries());
        book = bookRepository.save(book);
        return BookDTO.fromEntity(book);
    }

    public Book findById(Long id) {
        return bookRepository.findById(id).get();

    }

}
