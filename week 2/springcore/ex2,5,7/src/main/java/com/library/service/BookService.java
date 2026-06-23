package com.library.service;

import com.library.repository.BookRepository;
public class BookService {

    private final String libraryName;
    private BookRepository repository;

    public BookService(String libraryName) {
        this.libraryName = libraryName;
    }

    public void setRepository(BookRepository repository) {
        this.repository = repository;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public String findBook(int id) {
        return repository.getBookById(id);
    }
}
