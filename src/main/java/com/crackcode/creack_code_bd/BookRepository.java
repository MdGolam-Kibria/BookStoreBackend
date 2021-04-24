package com.crackcode.creack_code_bd;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByIsActiveTrue();

    @Query(value
            = "SELECT * FROM crack_code_bd.tbl_book  where crack_code_bd.tbl_book.category_id= :id",
            nativeQuery = true)
    List<Book> findBookByCategoryId(@Param("id") Long id);

    @Query(value = "SELECT * FROM crack_code_bd.tbl_book where crack_code_bd.tbl_book.name like %:name%", nativeQuery = true)
    List<Book> findByName(@Param("name") String name);

    Book findBookByIdAndIsActiveTrue(Long id);
}
