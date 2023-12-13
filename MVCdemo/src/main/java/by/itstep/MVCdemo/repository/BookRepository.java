package by.itstep.MVCdemo.repository;

import by.itstep.MVCdemo.model.Book;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class BookRepository {
    private List<Book> bookList;

    public BookRepository() {
        bookList = new ArrayList<>();
        bookList.add(new Book(1L,10, "Война и мир"));
        bookList.add(new Book(2L,25, "Java в примерах и задачах"));
    }

    public List<Book> findAll(){
        return bookList;
    }

    public Optional<Book> findById(Long id){
        return bookList.stream().filter(book -> book.getId() == id).findFirst();
    }
}
