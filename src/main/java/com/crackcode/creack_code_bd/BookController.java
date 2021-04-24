package com.crackcode.creack_code_bd;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@ApiController
public class BookController {
    private final BookService bookService;
    private final BookRepository bookRepository;
    private final BookCategoryRepository bookCategoryRepository;

    public BookController(BookService bookService, BookRepository bookRepository, BookCategoryRepository bookCategoryRepository) {
        this.bookService = bookService;
        this.bookRepository = bookRepository;
        this.bookCategoryRepository = bookCategoryRepository;
    }

    @GetMapping("/BookList")
    public List<Book> getAllBook() {
        List<Book> bookList = bookService.getBooks();
        return bookList;
    }

    @GetMapping("book/{ids}")
    private List<Book> bookList(@PathVariable Long ids) {
        return bookRepository.findBookByCategoryId(ids);
    }

    @GetMapping("/allCategory")
    public List<BookCategory> getAllBookCategory() {
        return bookCategoryRepository.findAll();
    }

    @GetMapping("/getBookByName/{name}")
    public List<Book> getBookByName(@PathVariable String name) {
        return bookRepository.findByName(name);
    }

    @GetMapping("/getBookById/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookRepository.findBookByIdAndIsActiveTrue(id);
    }


}
