package com.ibrahimciftci.enoca.service;

import com.ibrahimciftci.enoca.dto.BookDTO;
import com.ibrahimciftci.enoca.dto.LibraryDTO;
import com.ibrahimciftci.enoca.model.Library;
import com.ibrahimciftci.enoca.repository.ILibraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LibraryService {

    private final ILibraryRepository libraryRepository;

    public List<LibraryDTO> libraryList() {
        return new ArrayList<>(libraryRepository.findAll().stream().map(LibraryDTO::fromEntity).toList());
    }

    public LibraryDTO saveLibrary(LibraryDTO dto) {

        Library library = libraryRepository.save(Library.fromDTO(dto));
        return LibraryDTO.fromEntity(library);
    }

    public boolean deleteById(Long id) {
        libraryRepository.deleteById(id);
        return true;
    }

    public LibraryDTO update(Long id, LibraryDTO dto) {
        Library temp = findById(id);
        temp.setName(dto.getName());
        temp.setAddress(dto.getAddress());
        temp.updateBooks(dto.getBooks());
        libraryRepository.save(temp);
        return LibraryDTO.fromEntity(temp);
    }

    public Library findById(Long id) {
        return libraryRepository.findById(id).orElseThrow(() -> new RuntimeException("Library could not be found"));
    }

}
