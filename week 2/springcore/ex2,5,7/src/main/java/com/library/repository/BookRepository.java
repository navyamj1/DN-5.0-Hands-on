package com.library.repository;
public class BookRepository {

    public String getBookById(int id) {
        if (id == 1) {
            return "six of crows";
        }
        return "unknown book";
    }
}
