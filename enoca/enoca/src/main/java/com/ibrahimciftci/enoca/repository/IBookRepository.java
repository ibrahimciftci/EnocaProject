package com.ibrahimciftci.enoca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibrahimciftci.enoca.model.Book;

public interface IBookRepository extends JpaRepository<Book, Long>{
	

}
