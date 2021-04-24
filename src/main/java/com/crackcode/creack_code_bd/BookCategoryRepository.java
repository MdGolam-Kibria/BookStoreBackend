package com.crackcode.creack_code_bd;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


//@CrossOrigin("http://localhost:8080")
//@RepositoryRestResource(collectionResourceRel = "category",path = "book-category")
public interface BookCategoryRepository extends JpaRepository<BookCategory, Long> {
    @Override
    List<BookCategory> findAll();

}
