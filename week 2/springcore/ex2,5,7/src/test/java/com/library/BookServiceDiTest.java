package com.library;

import com.library.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BookServiceDiTest {

    @Test
    void bothInjectionsWired() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService service = context.getBean(BookService.class);

        assertEquals("six of crows", service.findBook(1));
        assertEquals("city central library", service.getLibraryName());

        context.close();
    }
}
