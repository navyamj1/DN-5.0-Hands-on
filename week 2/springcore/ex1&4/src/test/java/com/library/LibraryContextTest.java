package com.library;

import com.library.repository.BookRepository;
import com.library.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
class LibraryContextTest {

    @Test
    void contextLoadsBothBeans() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService service = context.getBean(BookService.class);
        BookRepository repo = context.getBean(BookRepository.class);

        assertNotNull(service);
        assertNotNull(repo);
        assertEquals("six of crows", repo.getBookById(1));

        context.close();
    }
}
