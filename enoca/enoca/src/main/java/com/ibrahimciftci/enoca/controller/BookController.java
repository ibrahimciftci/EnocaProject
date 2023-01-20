package com.ibrahimciftci.enoca.controller;

import java.util.List;

import com.ibrahimciftci.enoca.dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibrahimciftci.enoca.model.Book;
import com.ibrahimciftci.enoca.service.BookService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping(path = "/list")
    public ResponseEntity<List<BookDTO>> listAll() {
        return ResponseEntity.ok(bookService.bookList());
    }

    @PostMapping("/add")
    public ResponseEntity<BookDTO> add(@RequestBody BookDTO dto) {
        return ResponseEntity.ok(bookService.saveBook(dto));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        bookService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("update/{id}")
    public ResponseEntity<BookDTO> update(@PathVariable Long id, @RequestBody BookDTO book) {
        return ResponseEntity.ok(bookService.update(id, book));
    }

}
