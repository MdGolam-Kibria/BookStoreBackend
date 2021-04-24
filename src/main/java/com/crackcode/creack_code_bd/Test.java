package com.crackcode.creack_code_bd;

import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Date;

@Configuration
public class Test {

    private final BookCategoryRepository bookCategoryRepository;
    private final BookRepository bookRepository;

    public Test(BookCategoryRepository bookCategoryRepository, BookRepository bookRepository) {
        this.bookCategoryRepository = bookCategoryRepository;
        this.bookRepository = bookRepository;
    }


    // @PostConstruct
    public void test() {

        for (int i = 0; i < 10; i++) {
            Book book = new Book();
            book.setSku("okkk");
            book.setName("physics");
            book.setDescription("A simple, unstyled, shop home page template with star icons and a header carousel" +
                    "A simple, unstyled, shop home page template with star icons and a header carousel" +
                    "A simple, unstyled, shop home page template with star icons and a header carousel");
            book.setQuantity(BigDecimal.valueOf(73));
            book.setUnitPrice(BigDecimal.valueOf(700.01));
            book.setImageUrl("./assets/books/ios.png");
            book.setIsActive(true);
            book.setUnitsInStock(100);
            book.setCreatedOn(new Date());
            book.setUpdatedOn(null);

            BookCategory category = new BookCategory();
            category.setCategoryName("Books");
            category = bookCategoryRepository.save(category);
            book.setBookCategory(category);
            book = bookRepository.save(book);
        }

    }
}
