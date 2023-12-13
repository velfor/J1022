package by.itstep.MVCdemo.model.repository;

import by.itstep.MVCdemo.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private List<Book> bookList;

    {
        bookList.add(new Book(10, "Война и мир"));
        bookList.add(new Book(25, "Java в примерах и задачах"));
    }

    public BookRepository() {
        bookList = new ArrayList<>();
    }

}
