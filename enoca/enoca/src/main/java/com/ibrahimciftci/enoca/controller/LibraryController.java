package com.ibrahimciftci.enoca.controller;

import java.util.List;

import com.ibrahimciftci.enoca.dto.LibraryDTO;
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

import com.ibrahimciftci.enoca.model.Library;
import com.ibrahimciftci.enoca.service.LibraryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/library")
@RequiredArgsConstructor
public class LibraryController {

    private final LibraryService libraryService;

    @GetMapping(path = "/list")
    public List<LibraryDTO> listAll() {
        return libraryService.libraryList();
    }

    @PostMapping("/add")
    public ResponseEntity<LibraryDTO> add(@RequestBody LibraryDTO dto) {

        return ResponseEntity.ok(libraryService.saveLibrary(dto));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        libraryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("update/{id}")
    public ResponseEntity<LibraryDTO> update(@PathVariable Long id, @RequestBody LibraryDTO dto) {
        return ResponseEntity.ok(libraryService.update(id, dto));
    }

}
