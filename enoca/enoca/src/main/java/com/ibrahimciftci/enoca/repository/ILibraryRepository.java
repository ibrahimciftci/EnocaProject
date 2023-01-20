package com.ibrahimciftci.enoca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.ibrahimciftci.enoca.model.Library;

@Transactional
public interface ILibraryRepository extends JpaRepository<Library, Long>{

}
